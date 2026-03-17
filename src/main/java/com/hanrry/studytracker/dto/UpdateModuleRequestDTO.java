package com.hanrry.studytracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record UpdateModuleRequestDTO(
        String title,
        String description,

        @Schema(example = "5")
        Integer position
) {
}
