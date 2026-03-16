package com.hanrry.studytracker.service;

import com.hanrry.studytracker.dto.DashboardResponseDTO;
import com.hanrry.studytracker.entity.StudySession;
import com.hanrry.studytracker.entity.User;
import com.hanrry.studytracker.exception.ResourceNotFoundException;
import com.hanrry.studytracker.repository.LessonProgressRepository;
import com.hanrry.studytracker.repository.StudySessionRepository;
import com.hanrry.studytracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    private final UserRepository userRepository;
    private final StudySessionRepository studySessionRepository;
    private final LessonProgressRepository lessonProgressRepository;

    public DashboardService(
            UserRepository userRepository,
            StudySessionRepository studySessionRepository,
            LessonProgressRepository lessonProgressRepository
    ) {
        this.userRepository = userRepository;
        this.studySessionRepository = studySessionRepository;
        this.lessonProgressRepository = lessonProgressRepository;
    }

    public DashboardResponseDTO getDashboard(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User not found with id: " + userId));

        List<StudySession> sessions = studySessionRepository.findByUserId(user.getId());

        long totalStudySessions = sessions.size();

        long totalMinutesStudied = 0;

        for (StudySession session : sessions) {
            totalMinutesStudied += session.getDurationMinutes();
        }
        double totalHoursStudied = totalMinutesStudied / 60.0;

        long completedLessons = lessonProgressRepository.countByUserIdAndCompletedTrue(userId);

        long uncompletedLessons = lessonProgressRepository.countByUserIdAndCompletedFalse(userId);

        return new DashboardResponseDTO(
                userId,
                totalStudySessions,
                totalHoursStudied,
                completedLessons,
                uncompletedLessons
        );
    }
}
