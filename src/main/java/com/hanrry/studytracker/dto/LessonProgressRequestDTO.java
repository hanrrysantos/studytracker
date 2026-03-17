package com.hanrry.studytracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record LessonProgressRequestDTO(

        @NotNull(message = "User id is required")
        @Schema(example = "1")
        Long userId,

        @NotNull(message = "User id is required")
        @Schema(example = "1")
        Long lessonId
){
}
