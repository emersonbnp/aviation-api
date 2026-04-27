package com.aviation.api.application.entrypoint.rest.v1.controller.model;

public record AviationAirportInfoResponseDTO(
    String icaoId,
    String iataId,
    String faaId,
    String name,
    String state,
    String country,
    String source,
    String type,
    String lat,
    String lon,
    String elev,
    String magdec,
    String owner,
    AviationAirportInfoResponseRunwayDTO[] runways) {}
