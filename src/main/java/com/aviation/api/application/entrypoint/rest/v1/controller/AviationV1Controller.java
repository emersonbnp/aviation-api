package com.aviation.api.application.entrypoint.rest.v1.controller;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import com.aviation.api.application.entrypoint.rest.v1.controller.model.AviationAirportInfoResponseDTO;
import com.aviation.api.application.entrypoint.rest.v1.controller.model.ErrorResponseDTO;
import com.aviation.api.core.DataProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/v1/aviation")
public class AviationV1Controller {

  private final DataProvider dataProvider;

  public AviationV1Controller(DataProvider dataProvider) {
    this.dataProvider = dataProvider;
  }

  @Operation(
      summary = "Get airport information",
      description =
          "Get airport information by station ID(s) or geographic bounding box. Station IDs can be ICAO or IATA codes. Bounding box is defined by two points (lat0, lon0, lat1, lon1).")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "successful operation",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = AviationAirportInfoResponseDTO.class))),
    @ApiResponse(
        responseCode = "400",
        description = "Input validation errors",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponseDTO.class))),
    @ApiResponse(
        responseCode = "401",
        description = "Not Authorized",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponseDTO.class))),
    @ApiResponse(
        responseCode = "403",
        description = "Forbidden",
        content =
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponseDTO.class)))
  })
  @GetMapping(value = "/airport", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getAirport(
      @Parameter(
              name = "ids",
              in = QUERY,
              description = "Station ID(s)",
              examples = {
                @ExampleObject(name = "None", value = ""),
                @ExampleObject(name = "A single ICAO Id", value = "KMCI")
              })
          @RequestParam(required = false)
          String ids,
      @Parameter(
              name = "bbox",
              in = QUERY,
              description = "Geographic bounding box (lat0, lon0, lat1, lon1)",
              examples = {
                @ExampleObject(name = "None", value = ""),
                @ExampleObject(name = "A small box around Chicago", value = "40,-90,45,-85")
              })
          @RequestParam(required = false)
          String bbox) {
    return ResponseEntity.ok(dataProvider.getAirport(ids, bbox));
  }
}
