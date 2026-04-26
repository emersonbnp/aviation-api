package com.aviation.api.application.entrypoint.rest.v1.controller.exception;

import com.aviation.api.application.entrypoint.rest.v1.controller.model.ErrorResponse;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class StatusInformationException extends RuntimeException {
  private final HttpStatusCode statusCode;
  private final ErrorResponse errorResponse;

  public StatusInformationException(HttpStatusCode statusCode, ErrorResponse errorResponse) {
    super(errorResponse.error());
    this.statusCode = statusCode;
    this.errorResponse = errorResponse;
  }
}
