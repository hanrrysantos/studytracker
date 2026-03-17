package com.hanrry.studytracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record UpdateStudySessionRequestDTO(

        @Schema(example = "1")
        Long lessonId,
        @Positive(message = "Duration must be greater than zero")
        @Schema(example = "20")
        Integer durationMinutes,
        String notes,
        LocalDateTime studiedAt
) {
}
