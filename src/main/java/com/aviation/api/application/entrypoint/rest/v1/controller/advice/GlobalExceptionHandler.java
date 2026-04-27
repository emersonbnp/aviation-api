package com.aviation.api.application.entrypoint.rest.v1.controller.advice;

import com.aviation.api.application.entrypoint.rest.v1.controller.exception.StatusInformationException;
import com.aviation.api.application.entrypoint.rest.v1.controller.model.ErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Global exception handler that converts exceptions into a consistent ErrorResponse with HTTP
 * status code, reason phrase and a message.
 */
@SuppressWarnings("unused")
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(StatusInformationException.class)
  protected ResponseEntity<ErrorResponseDTO> handleMethodArgumentNotValid(
      StatusInformationException ex, WebRequest request) {
    return ResponseEntity.status(ex.getStatusCode()).body(ex.getErrorResponse());
  }
}
