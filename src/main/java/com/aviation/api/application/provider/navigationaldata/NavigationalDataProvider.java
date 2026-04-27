package com.aviation.api.application.provider.navigationaldata;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;

import com.aviation.api.application.entrypoint.rest.v1.controller.exception.StatusInformationException;
import com.aviation.api.application.entrypoint.rest.v1.controller.model.ErrorResponseDTO;
import com.aviation.api.application.provider.navigationaldata.model.AirportInfoResponse;
import com.aviation.api.core.DataProvider;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@SuppressWarnings("unused")
@Service
public class NavigationalDataProvider implements DataProvider {

  private final RestClient client;
  private final RetryTemplate retryTemplate;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public NavigationalDataProvider(RestClient navDataClient, RetryTemplate retryTemplate) {
    this.client = navDataClient;
    this.retryTemplate = retryTemplate;
  }

  @Override
  public List<AirportInfoResponse> getAirport(String ids, String bbox) {
    final var listType = new ParameterizedTypeReference<List<AirportInfoResponse>>() {};
    try {
      return retryTemplate.execute(
          context -> {
            final var attempt = context.getRetryCount() + 1;
            logger.debug("Attempt {} to fetch data from {}", attempt, "/airport");
            return requestAirportInfo(ids, bbox, listType);
          });
    } catch (Exception e) {
      logger.error("HTTP error while fetching data from '/airport': {}", e.getMessage(), e);
      if (e instanceof HttpClientErrorException httpEx) {
        final var error = requireNonNull(httpEx.getResponseBodyAs(ErrorResponseDTO.class));
        throw new StatusInformationException(httpEx.getStatusCode(), error);
      }
      throw e;
    }
  }

  private List<AirportInfoResponse> requestAirportInfo(
      String ids, String bbox, ParameterizedTypeReference<List<AirportInfoResponse>> listType) {
    return client
        .get()
        .uri(
            uriBuilder ->
                uriBuilder
                    .path("/airport")
                    .queryParamIfPresent("ids", ofNullable(ids))
                    .queryParamIfPresent("bbox", ofNullable(bbox))
                    .queryParam("format", "json")
                    .build())
        .retrieve()
        .body(listType);
  }
}
