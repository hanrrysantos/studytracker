package com.hanrry.studytracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record CourseRequestDTO(
        String title,
        String description,

        @Schema(example = "1")
        Long userId,

        @Schema(example = "1")
        Long categoryId
){
}
