package com.hanrry.studytracker.dto;

public record UpdateModuleRequestDTO(
        String title,
        String description,
        Integer position
) {
}
