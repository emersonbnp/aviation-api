package com.aviation.api.application.entrypoint.rest.v1.controller.exception;

import com.aviation.api.application.entrypoint.rest.v1.controller.model.ErrorResponseDTO;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class StatusInformationException extends RuntimeException {
  private final HttpStatusCode statusCode;
  private final ErrorResponseDTO errorResponse;

  public StatusInformationException(HttpStatusCode statusCode, ErrorResponseDTO errorResponse) {
    super(String.valueOf(errorResponse.error()));
    this.statusCode = statusCode;
    this.errorResponse = errorResponse;
  }
}
