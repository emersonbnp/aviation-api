package com.aviation.api.application.provider.navigationaldata.model;

public record AirportInfoResponseRunway(
    String id, String dimension, String surface, int alignment) {}
