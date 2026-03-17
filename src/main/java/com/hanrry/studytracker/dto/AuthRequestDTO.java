package com.hanrry.studytracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthRequestDTO (
        @NotBlank
        @Email
        @Schema(example = "admin@email.com")
        String email,

        @NotBlank
        @Schema(example = "admin123")
        String password
){
}
