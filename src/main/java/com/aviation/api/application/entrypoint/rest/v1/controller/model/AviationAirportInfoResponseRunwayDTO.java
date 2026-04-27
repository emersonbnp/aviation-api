package com.aviation.api.application.entrypoint.rest.v1.controller.model;

public record AviationAirportInfoResponseRunwayDTO(
    String id, String dimension, String surface, int alignment) {}
