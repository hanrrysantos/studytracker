package com.hanrry.studytracker.dto;

public record CreateCourseRequestDTO (
        String title,
        String description,
        Long userId,
        Long categoryId
){
}
