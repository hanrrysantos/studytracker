package com.hanrry.studytracker.dto;

import jakarta.validation.constraints.NotNull;

public record LessonProgressRequestDTO(

        @NotNull(message = "User id is required")
        Long userId,

        @NotNull(message = "User id is required")
        Long lessonId
){
}
