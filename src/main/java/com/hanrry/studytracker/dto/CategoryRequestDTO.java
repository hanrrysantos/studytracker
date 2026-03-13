package com.hanrry.studytracker.dto;

public record CreateCategoryRequestDTO(
        String name,
        String description,
        Long userId
) {
}
