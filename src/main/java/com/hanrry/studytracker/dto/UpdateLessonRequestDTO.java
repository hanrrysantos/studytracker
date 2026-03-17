package com.hanrry.studytracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record UpdateLessonRequestDTO (
        String title,
        String description,

        @Schema(example = "5")
        Integer position,

        @Schema(example = "20")
        Integer estimatedMinutes,
        String lessonUrl
){
}
