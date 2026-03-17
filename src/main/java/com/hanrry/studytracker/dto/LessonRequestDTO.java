package com.hanrry.studytracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record LessonRequestDTO (
        String title,
        String description,

        @Schema(example = "5")
        Integer position,

        @Schema(example = "20")
        Integer estimatedMinutes,
        String lessonUrl,

        @Schema(example = "1")
        Long moduleId
){
}

