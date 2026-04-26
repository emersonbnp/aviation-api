package com.aviation.api.application.entrypoint.rest.v1.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.aviation.api.core.DataProvider;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(AviationV1Controller.class)
class AviationV1Controller2xxTest {

  @Autowired private MockMvc mockMvc;
  @MockitoBean private DataProvider dataProvider;
  private static final ObjectMapper mapper = new ObjectMapper();
  private static final TypeFactory typeFactory = mapper.getTypeFactory();

  @Test
  void should_return_ok_with_station_info_when_station_info_requested() throws Exception {
    // Given
    final var stationInfoData = List.of(TextNode.valueOf("station-data"));
    final var listType = typeFactory.constructCollectionType(List.class, JsonNode.class);
    when(dataProvider.getStationInfo(any()))
        .thenReturn(mapper.convertValue(stationInfoData, listType));

    // When
    mockMvc
        .perform(get("/v1/aviation/stationinfo").param("id", "KJFK"))
        // Then
        .andExpect(status().isOk());

    verify(dataProvider).getStationInfo(any());
  }

  @Test
  void should_return_empty_list_when_station_info_has_no_results() throws Exception {
    // Given
    when(dataProvider.getStationInfo(any())).thenReturn(List.of());

    // When
    mockMvc
        .perform(get("/v1/aviation/stationinfo").param("id", "INVALID"))
        // Then
        .andExpect(status().isOk());

    verify(dataProvider).getStationInfo(any());
  }

  @Test
  void should_return_ok_with_airport_when_airport_requested() throws Exception {
    // Given
    final var airportData = List.of(TextNode.valueOf("airport-data"));
    final var listType = typeFactory.constructCollectionType(List.class, JsonNode.class);
    when(dataProvider.getAirport(any())).thenReturn(mapper.convertValue(airportData, listType));

    // When
    mockMvc
        .perform(get("/v1/aviation/airport").param("airport_id", "KJF"))
        // Then
        .andExpect(status().isOk());

    verify(dataProvider).getAirport(any());
  }

  @Test
  void should_return_empty_airport_list_when_no_results_found() throws Exception {
    // Given
    when(dataProvider.getAirport(any())).thenReturn(List.of());

    // When
    mockMvc
        .perform(get("/v1/aviation/airport"))
        // Then
        .andExpect(status().isOk());

    verify(dataProvider).getAirport(any());
  }

  @Test
  void should_return_ok_with_navaid_when_navaid_requested() throws Exception {
    // Given
    final var navaidData = List.of(TextNode.valueOf("navaid-data"));
    final var listType = typeFactory.constructCollectionType(List.class, JsonNode.class);
    when(dataProvider.getNavaid(any())).thenReturn(mapper.convertValue(navaidData, listType));

    // When
    mockMvc
        .perform(get("/v1/aviation/navaid").param("navaid_id", "JFK"))
        // Then
        .andExpect(status().isOk());

    verify(dataProvider).getNavaid(any());
  }

  @Test
  void should_return_empty_navaid_list_when_no_results_found() throws Exception {
    // Given
    when(dataProvider.getNavaid(any())).thenReturn(List.of());

    // When
    mockMvc
        .perform(get("/v1/aviation/navaid"))
        // Then
        .andExpect(status().isOk());

    verify(dataProvider).getNavaid(any());
  }

  @Test
  void should_return_ok_with_fix_when_fix_requested() throws Exception {
    // Given
    final var fixData = List.of(TextNode.valueOf("fix-data"));
    final var listType = typeFactory.constructCollectionType(List.class, JsonNode.class);
    when(dataProvider.getFix(any())).thenReturn(mapper.convertValue(fixData, listType));

    // When
    mockMvc
        .perform(get("/v1/aviation/fix").param("fix_id", "ALLIE"))
        // Then
        .andExpect(status().isOk());

    verify(dataProvider).getFix(any());
  }

  @Test
  void should_return_empty_fix_list_when_no_results_found() throws Exception {
    // Given
    when(dataProvider.getFix(any())).thenReturn(List.of());

    // When
    mockMvc
        .perform(get("/v1/aviation/fix"))
        // Then
        .andExpect(status().isOk());

    verify(dataProvider).getFix(any());
  }

  @Test
  void should_return_ok_with_feature_when_feature_requested() throws Exception {
    // Given
    final var featureData = List.of(TextNode.valueOf("feature-data"));
    final var listType = typeFactory.constructCollectionType(List.class, JsonNode.class);
    when(dataProvider.getFeature(any())).thenReturn(mapper.convertValue(featureData, listType));

    // When
    mockMvc
        .perform(get("/v1/aviation/feature").param("feature_id", "MTN"))
        // Then
        .andExpect(status().isOk());

    verify(dataProvider).getFeature(any());
  }

  @Test
  void should_return_empty_feature_list_when_no_results_found() throws Exception {
    // Given
    when(dataProvider.getFeature(any())).thenReturn(List.of());

    // When
    mockMvc
        .perform(get("/v1/aviation/feature"))
        // Then
        .andExpect(status().isOk());

    verify(dataProvider).getFeature(any());
  }

  @Test
  void should_return_ok_with_obstacle_when_obstacle_requested() throws Exception {
    // Given
    final var obstacleData = List.of(TextNode.valueOf("obstacle-data"));
    final var listType = typeFactory.constructCollectionType(List.class, JsonNode.class);
    when(dataProvider.getObstacle(any())).thenReturn(mapper.convertValue(obstacleData, listType));

    // When
    mockMvc
        .perform(get("/v1/aviation/obstacle").param("obstacle_id", "BLDG"))
        // Then
        .andExpect(status().isOk());

    verify(dataProvider).getObstacle(any());
  }

  @Test
  void should_return_empty_obstacle_list_when_no_results_found() throws Exception {
    // Given
    when(dataProvider.getObstacle(any())).thenReturn(List.of());

    // When
    mockMvc
        .perform(get("/v1/aviation/obstacle"))
        // Then
        .andExpect(status().isOk());

    verify(dataProvider).getObstacle(any());
  }

  @Test
  void should_return_ok_with_multiple_parameters_when_station_info_requested_with_filters()
      throws Exception {
    // Given
    final var stationInfoData = List.of(TextNode.valueOf("filtered-station-data"));
    final var listType = typeFactory.constructCollectionType(List.class, JsonNode.class);
    when(dataProvider.getStationInfo(any()))
        .thenReturn(mapper.convertValue(stationInfoData, listType));

    // When
    mockMvc
        .perform(
            get("/v1/aviation/stationinfo")
                .param("id", "KJFK")
                .param("country", "US")
                .param("state", "NY"))
        // Then
        .andExpect(status().isOk());

    verify(dataProvider).getStationInfo(any());
  }
}
