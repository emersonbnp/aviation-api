package com.aviation.api.application.entrypoint.rest.v1.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import com.aviation.api.application.entrypoint.rest.v1.controller.model.request.AirportRequest;
import com.aviation.api.application.entrypoint.rest.v1.controller.model.request.FeatureRequest;
import com.aviation.api.application.entrypoint.rest.v1.controller.model.request.FixRequest;
import com.aviation.api.application.entrypoint.rest.v1.controller.model.request.NavaidRequest;
import com.aviation.api.application.entrypoint.rest.v1.controller.model.request.ObstacleRequest;
import com.aviation.api.application.entrypoint.rest.v1.controller.model.request.StationInfoRequest;
import com.aviation.api.application.entrypoint.rest.v1.controller.model.response.ResponseWrapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/v1/aviation")
public class AviationV1Controller {

  @GetMapping(value = "/stationinfo", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getStationInfo(@Valid @ModelAttribute StationInfoRequest req) {
    return ResponseEntity.ok(new ResponseWrapper(null, 0));
  }

  @GetMapping(value = "/airport", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getAirport(@Valid @ModelAttribute AirportRequest req) {
    return ResponseEntity.ok(new ResponseWrapper(null, 0));
  }

  @GetMapping(value = "/navaid", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getNavaid(@Valid @ModelAttribute NavaidRequest req) {
    return ResponseEntity.ok(new ResponseWrapper(null, 0));
  }

  @GetMapping(value = "/fix", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getFix(@Valid @ModelAttribute FixRequest req) {
    return ResponseEntity.ok(new ResponseWrapper(null, 0));
  }

  @GetMapping(value = "/feature", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getFeature(@Valid @ModelAttribute FeatureRequest req) {
    return ResponseEntity.ok(new ResponseWrapper(null, 0));
  }

  @GetMapping(value = "/obstacle", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getObstacle(@Valid @ModelAttribute ObstacleRequest req) {
    return ResponseEntity.ok(new ResponseWrapper(null, 0));
  }
}
