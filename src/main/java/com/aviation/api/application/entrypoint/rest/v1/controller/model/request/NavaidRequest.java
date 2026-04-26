package com.aviation.api.application.entrypoint.rest.v1.controller.model.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/** Request model for /api/data/navaid */
public record NavaidRequest(
    @Size(max = 64) String ids,
    @Pattern(regexp = BoundingBox.REGEX) String bbox,
    @Pattern(regexp = "raw|json|geojson") String format) {}
