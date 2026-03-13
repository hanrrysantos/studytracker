package com.hanrry.studytracker.dto;

public record UpdateLessonRequestDTO (
        String title,
        String description,
        Integer position,
        Integer estimatedMinutes,
        String lessonUrl
){
}
