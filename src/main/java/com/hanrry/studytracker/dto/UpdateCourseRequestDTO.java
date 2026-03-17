package com.hanrry.studytracker.dto;

import com.hanrry.studytracker.entity.CourseStatus;
import io.swagger.v3.oas.annotations.media.Schema;

public record UpdateCourseRequestDTO(
        String title,
        String description,
        CourseStatus status,

        @Schema(example = "1")
        Long categoryId
) {
}
