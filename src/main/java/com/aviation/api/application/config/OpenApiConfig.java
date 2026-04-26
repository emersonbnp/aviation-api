package com.aviation.api.application.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Basic OpenAPI configuration for Swagger UI */
@SuppressWarnings("unused")
@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI aviationOpenAPI() {
    return new OpenAPI()
        .externalDocs(
            new ExternalDocumentation()
                .description("AviationWeather.gov API")
                .url("https://aviationweather.gov/data/api/#schema"))
        .info(
            new Info()
                .title("Aviation API")
                .version("v1")
                .description(
                    "API exposing aviation weather and navigational data (auto-generated OpenAPI)"));
  }
}
