package com.hanrry.studytracker.dto;

import com.hanrry.studytracker.entity.CourseStatus;

public record UpdateCourseRequestDTO(
        String title,
        String description,
        CourseStatus status,
        Long categoryId
) {
}
