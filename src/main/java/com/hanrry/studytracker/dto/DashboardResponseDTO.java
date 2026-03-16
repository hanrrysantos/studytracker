package com.hanrry.studytracker.dto;

import java.time.LocalDateTime;

public record DashboardResponseDTO (
        Long userId,
        long totalStudySessions,
        double totalHoursStudied,
        long completedLessons,
        long uncompletedLessons
){
}
