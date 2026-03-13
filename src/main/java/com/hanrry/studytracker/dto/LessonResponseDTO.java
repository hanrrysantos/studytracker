package com.hanrry.studytracker.dto;

import java.time.LocalDateTime;

public record LessonResponseDTO (
        Long id,
        String title,
        String description,
        Integer position,
        Integer estimatedMinutes,
        String lessonUrl,
        LocalDateTime createdAt

){
}
