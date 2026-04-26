package com.aviation.api.application.entrypoint.rest.v1.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatusCode.valueOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.aviation.api.core.DataProvider;
import jakarta.servlet.ServletException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpClientErrorException;

@WebMvcTest(AviationV1Controller.class)
class AviationV1Controller4xxTest {

  @Autowired private MockMvc mockMvc;
  @MockitoBean private DataProvider dataProvider;

  @ParameterizedTest
  @ValueSource(ints = {400, 401, 403, 500, 503})
  void should_propagate_exception_when_http_error_getting_airport(int statusCode) {
    // Given
    when(dataProvider.getAirport(any()))
        .thenThrow(new HttpClientErrorException(valueOf(statusCode)));

    // When
    final var exception =
        assertThrows(ServletException.class, () -> mockMvc.perform(get("/v1/aviation/airport")));

    // Then
    assertTrue(exception.getMessage().endsWith(valueOf(statusCode).toString()));
  }

  @ParameterizedTest
  @ValueSource(ints = {400, 401, 403, 500, 503})
  void should_propagate_exception_when_http_error_getting_nava_id(int statusCode) {
    // Given
    when(dataProvider.getNavaid(any()))
        .thenThrow(new HttpClientErrorException(valueOf(statusCode)));

    // When
    final var exception =
        assertThrows(ServletException.class, () -> mockMvc.perform(get("/v1/aviation/navaid")));

    // Then
    assertTrue(exception.getMessage().endsWith(valueOf(statusCode).toString()));
  }

  @ParameterizedTest
  @ValueSource(ints = {400, 401, 403, 500, 503})
  void should_propagate_exception_when_http_error_getting_fix(int statusCode) {
    // Given
    when(dataProvider.getFix(any())).thenThrow(new HttpClientErrorException(valueOf(statusCode)));

    // When
    final var exception =
        assertThrows(ServletException.class, () -> mockMvc.perform(get("/v1/aviation/fix")));

    // Then
    assertTrue(exception.getMessage().endsWith(valueOf(statusCode).toString()));
  }

  @ParameterizedTest
  @ValueSource(ints = {400, 401, 403, 500, 503})
  void should_propagate_exception_when_http_error_getting_feature(int statusCode) {
    // Given
    when(dataProvider.getFeature(any()))
        .thenThrow(new HttpClientErrorException(valueOf(statusCode)));

    // When
    final var exception =
        assertThrows(ServletException.class, () -> mockMvc.perform(get("/v1/aviation/feature")));

    // Then
    assertTrue(exception.getMessage().endsWith(valueOf(statusCode).toString()));
  }

  @ParameterizedTest
  @ValueSource(ints = {400, 401, 403, 500, 503})
  void should_propagate_exception_when_http_error_getting_obstacle(int statusCode) {
    // Given
    when(dataProvider.getObstacle(any()))
        .thenThrow(new HttpClientErrorException(valueOf(statusCode)));

    // When
    final var exception =
        assertThrows(ServletException.class, () -> mockMvc.perform(get("/v1/aviation/obstacle")));

    // Then
    assertTrue(exception.getMessage().endsWith(valueOf(statusCode).toString()));
  }

  @ParameterizedTest
  @ValueSource(ints = {400, 401, 403, 500, 503})
  void should_propagate_exception_when_http_error_getting_station_info(int statusCode) {
    // Given
    when(dataProvider.getStationInfo(any()))
        .thenThrow(new HttpClientErrorException(valueOf(statusCode)));

    // When
    final var exception =
        assertThrows(
            ServletException.class, () -> mockMvc.perform(get("/v1/aviation/stationinfo")));

    // Then
    assertTrue(exception.getMessage().endsWith(valueOf(statusCode).toString()));
  }
}
