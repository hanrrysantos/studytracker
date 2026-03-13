package com.hanrry.studytracker.dto;

import java.time.LocalDateTime;

public record CreateCategoryResponseDTO(
        Long id,
        String name,
        String description,
        LocalDateTime createdAt
) {
}
