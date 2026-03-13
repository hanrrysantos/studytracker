package com.hanrry.studytracker.dto;

public record CourseRequestDTO(
        String title,
        String description,
        Long userId,
        Long categoryId
){
}
