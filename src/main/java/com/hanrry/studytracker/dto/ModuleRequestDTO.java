package com.hanrry.studytracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ModuleRequestDTO (

        @NotBlank(message = "Title is required")
        String title,

        String description,

        @NotNull(message = "The position cannot be null")
        @Schema(example = "5")
        Integer position,

        @NotNull(message = "The id cannot be null")
        @Schema(example = "1")
        Long courseId
){
}
