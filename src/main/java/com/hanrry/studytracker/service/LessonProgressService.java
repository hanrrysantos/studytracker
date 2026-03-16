package com.hanrry.studytracker.service;

import com.hanrry.studytracker.dto.LessonProgressRequestDTO;
import com.hanrry.studytracker.dto.LessonProgressResponseDTO;
import com.hanrry.studytracker.entity.Lesson;
import com.hanrry.studytracker.entity.LessonProgress;
import com.hanrry.studytracker.entity.User;
import com.hanrry.studytracker.exception.ResourceNotFoundException;
import com.hanrry.studytracker.mapper.LessonProgressMapper;
import com.hanrry.studytracker.repository.LessonProgressRepository;
import com.hanrry.studytracker.repository.LessonRepository;
import com.hanrry.studytracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LessonProgressService {

    private final LessonProgressRepository lessonProgressRepository;
    private final LessonRepository lessonRepository;
    private final UserRepository userRepository;
    private final LessonProgressMapper lessonProgressMapper;

    public LessonProgressService(
            LessonProgressRepository lessonProgressRepository,
            LessonRepository lessonRepository,
            UserRepository userRepository,
            LessonProgressMapper lessonProgressMapper
    ) {
        this.lessonProgressRepository = lessonProgressRepository;
        this.lessonRepository = lessonRepository;
        this.userRepository = userRepository;
        this.lessonProgressMapper = lessonProgressMapper;
    }

    public LessonProgressResponseDTO completeLesson(LessonProgressRequestDTO request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User not found with id: " + request.userId()));

        Lesson lesson = lessonRepository.findById(request.lessonId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Lesson not found with id: " + request.lessonId()));

        LessonProgress lessonProgress = lessonProgressRepository
                .findByUserIdAndLessonId(request.userId(), request.lessonId())
                .orElseGet(() -> {
                    LessonProgress progress = new LessonProgress();
                    progress.setUser(user);
                    progress.setLesson(lesson);
                    return progress;
                });

        lessonProgress.setCompleted(true);
        lessonProgress.setCompletedAt(LocalDateTime.now());

        LessonProgress saved = lessonProgressRepository.save(lessonProgress);

        return lessonProgressMapper.toDTO(saved);
    }

    public LessonProgressResponseDTO unCompleteLesson(LessonProgressRequestDTO request) {

        LessonProgress lessonProgress = lessonProgressRepository
                .findByUserIdAndLessonId(request.userId(), request.lessonId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Lesson progress not found for user id: " + request.userId() + " and lesson id: " + request.lessonId()));

        lessonProgress.setCompleted(false);
        lessonProgress.setCompletedAt(null);

        LessonProgress saved = lessonProgressRepository.save(lessonProgress);

        return lessonProgressMapper.toDTO(saved);
    }

    public LessonProgressResponseDTO findProgress(Long userId, Long lessonId) {

        LessonProgress lessonProgress = lessonProgressRepository
                .findByUserIdAndLessonId(userId, lessonId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Lesson progress not found"));

        return lessonProgressMapper.toDTO(lessonProgress);
    }
}
