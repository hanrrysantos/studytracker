package com.hanrry.studytracker.dto;

public record LessonRequestDTO (
        String title,
        String description,
        Integer position,
        Integer estimatedMinutes,
        String lessonUrl,
        Long moduleId
){
}

