package com.aviation.api.application.entrypoint.rest.v1.controller.model.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/** Request model for /api/data/stationinfo */
public record StationInfoRequest(
    @Size(max = 512) String ids,
    @Pattern(regexp = BoundingBox.REGEX) String bbox,
    @Pattern(regexp = "raw|json|geojson|xml") String format) {}
