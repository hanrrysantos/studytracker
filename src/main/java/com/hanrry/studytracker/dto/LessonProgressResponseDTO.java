package com.hanrry.studytracker.dto;

import java.time.LocalDateTime;

public record LessonProgressResponseDTO(
        Long id,
        Long userId,
        Long lessonId,
        Boolean completed,
        LocalDateTime completedAt

) {
}
