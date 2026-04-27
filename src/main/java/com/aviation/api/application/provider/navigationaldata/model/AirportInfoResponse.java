package com.aviation.api.application.provider.navigationaldata.model;

public record AirportInfoResponse(
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
    AirportInfoResponseRunway[] runways) {}
