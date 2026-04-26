package com.aviation.api.application.entrypoint.rest.v1.controller.model.request;

import jakarta.validation.constraints.Pattern;

/** Request model for /api/data/feature */
public record FeatureRequest(
    @Pattern(regexp = BoundingBox.REGEX) String bbox,
    @Pattern(regexp = "raw|geojson") String format) {}
