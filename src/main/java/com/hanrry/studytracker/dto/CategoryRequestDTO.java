package com.hanrry.studytracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record CategoryRequestDTO(
        String name,
        String description,

        @Schema(example = "1")
        Long userId
) {
}
