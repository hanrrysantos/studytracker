package com.hanrry.studytracker.dto;

import java.time.LocalDateTime;

public record CreateUserResponseDTO(
        Long id,
        String name,
        String email,
        LocalDateTime createdAt
) {
}
