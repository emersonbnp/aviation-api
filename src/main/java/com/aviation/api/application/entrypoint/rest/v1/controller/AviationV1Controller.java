package com.aviation.api.application.entrypoint.rest.v1.controller;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import com.aviation.api.core.DataProvider;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import java.util.Map;
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

  @GetMapping(value = "/stationinfo", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getStationInfo(
      @Parameter(hidden = true) @RequestParam Map<String, Object> params,
      @Parameter(
              name = "ids",
              in = QUERY,
              description = "Station ID(s)",
              examples = {@ExampleObject(name = "A single ICAO Id", value = "KMCI")})
          String ids,
      @Parameter(
              name = "bbox",
              in = QUERY,
              description = "Geographic bounding box (lat0, lon0, lat1, lon1)",
              examples = {
                @ExampleObject(name = "A small box around Chicago", value = "40,-90,45,-85")
              })
          String bbox) {
    return ResponseEntity.ok(dataProvider.getStationInfo(params));
  }

  @GetMapping(value = "/airport", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getAirport(@RequestParam Map<String, Object> params) {
    return ResponseEntity.ok(dataProvider.getAirport(params));
  }

  @GetMapping(value = "/navaid", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getNavai(@RequestParam Map<String, Object> params) {
    return ResponseEntity.ok(dataProvider.getNavaid(params));
  }

  @GetMapping(value = "/fix", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getFix(@RequestParam Map<String, Object> params) {
    return ResponseEntity.ok(dataProvider.getFix(params));
  }

  @GetMapping(value = "/feature", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getFeature(@RequestParam Map<String, Object> params) {
    return ResponseEntity.ok(dataProvider.getFeature(params));
  }

  @GetMapping(value = "/obstacle", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getObstacle(@RequestParam Map<String, Object> params) {
    return ResponseEntity.ok(dataProvider.getObstacle(params));
  }
}
