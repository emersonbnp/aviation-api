package com.aviation.api.application.entrypoint.rest.v1.controller.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    description = "Error response DTO",
    example =
        """
    {
      "status": "error",
      "error": "string | object | array"
    }
    """)
public record ErrorResponseDTO(String status, Object error) {}
