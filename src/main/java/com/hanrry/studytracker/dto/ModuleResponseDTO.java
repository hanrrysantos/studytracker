package com.hanrry.studytracker.dto;

import java.time.LocalDateTime;

public record ModuleResponseDTO(
        Long id,
        String title,
        String description,
        Integer position,
        LocalDateTime createdAt
) {
}
