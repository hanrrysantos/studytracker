package com.hanrry.studytracker.dto;

import com.hanrry.studytracker.entity.CourseStatus;

import java.time.LocalDateTime;

public record CreateCourseResponseDTO(
        Long id,
        String title,
        String description,
        CourseStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
