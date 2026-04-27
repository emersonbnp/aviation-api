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
  void should_return_ok_with_airport_when_airport_requested() throws Exception {
    // Given
    final var airportData = List.of(TextNode.valueOf("airport-data"));
    final var listType = typeFactory.constructCollectionType(List.class, JsonNode.class);
    when(dataProvider.getAirport(any(), any()))
        .thenReturn(mapper.convertValue(airportData, listType));

    // When
    mockMvc
        .perform(get("/v1/aviation/airport").param("airport_id", "KJF"))
        // Then
        .andExpect(status().isOk());

    verify(dataProvider).getAirport(any(), any());
  }

  @Test
  void should_return_empty_airport_list_when_no_results_found() throws Exception {
    // Given
    when(dataProvider.getAirport(any(), any())).thenReturn(List.of());

    // When
    mockMvc
        .perform(get("/v1/aviation/airport"))
        // Then
        .andExpect(status().isOk());

    verify(dataProvider).getAirport(any(), any());
  }
}
