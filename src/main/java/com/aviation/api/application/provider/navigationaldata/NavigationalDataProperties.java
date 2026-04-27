package com.aviation.api.application.provider.navigationaldata;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "aviation.weather.api")
public record NavigationalDataProperties(
    String baseUrl, int maxAttempts, long initialInterval, long maxInterval, double multiplier) {}
