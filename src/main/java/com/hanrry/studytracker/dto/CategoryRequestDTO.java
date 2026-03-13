package com.hanrry.studytracker.dto;

public record CategoryRequestDTO(
        String name,
        String description,
        Long userId
) {
}
