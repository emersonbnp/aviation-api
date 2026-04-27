package com.aviation.api.application.provider.navigationaldata;

import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;

@SuppressWarnings("unused")
@Configuration
public class NavigationalDataConfiguration {

  @Bean
  public RetryTemplate retryTemplate(NavigationalDataProperties properties) {
    final var retryTemplate = new RetryTemplate();
    retryTemplate.setRetryPolicy(
        new SimpleRetryPolicy(
            properties.maxAttempts(),
            Map.of(Exception.class, true, ResourceAccessException.class, true)));

    final var backOffPolicy = new ExponentialBackOffPolicy();
    backOffPolicy.setInitialInterval(properties.initialInterval());
    backOffPolicy.setMultiplier(properties.multiplier());
    backOffPolicy.setMaxInterval(properties.maxInterval());
    retryTemplate.setBackOffPolicy(backOffPolicy);

    return retryTemplate;
  }

  @Bean
  public RestClient navDataClient(NavigationalDataProperties properties) {
    return RestClient.builder().baseUrl(properties.baseUrl()).build();
  }
}
