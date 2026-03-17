package com.hanrry.studytracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record LessonRequestDTO (
        String title,
        String description,
        Integer position,
        Integer estimatedMinutes,
        String lessonUrl,

        @Schema(example = "1")
        Long moduleId
){
}

