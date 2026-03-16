package com.hanrry.studytracker.dto;

import java.time.LocalDateTime;

public record StudySessionResponseDTO(
        Long id,
        Long userId,
        Long lessonId,
        Integer durationMinutes,
        String notes,
        LocalDateTime studiedAt
) {
}
