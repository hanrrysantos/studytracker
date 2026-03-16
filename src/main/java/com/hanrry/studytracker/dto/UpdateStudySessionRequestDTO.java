package com.hanrry.studytracker.dto;

import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record UpdateStudySessionRequestDTO(
        Long lessonId,
        @Positive(message = "Duration must be greater than zero")
        Integer durationMinutes,
        String notes,
        LocalDateTime studiedAt
) {
}
