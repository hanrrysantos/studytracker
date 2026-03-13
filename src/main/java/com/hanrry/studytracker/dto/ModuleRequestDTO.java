package com.hanrry.studytracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ModuleRequestDTO (

        @NotBlank(message = "Title is required")
        String title,

        String description,

        @NotNull(message = "The position cannot be null")
        Integer position,

        @NotNull(message = "The id cannot be null")
        Long courseId
){
}
