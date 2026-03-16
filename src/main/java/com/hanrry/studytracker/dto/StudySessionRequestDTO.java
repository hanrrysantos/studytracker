package com.hanrry.studytracker.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record StudySessionRequestDTO (
        @NotNull(message = "User id is required")
        Long userId,

        Long lessonId,

        @NotNull(message = "Duration is required")
        @Positive(message = "Duration must be greater than zero")
        Integer durationMinutes,

        String notes,

        @NotNull(message = "Studied date is required")
        LocalDateTime studiedAt
){
}
