package com.hanrry.studytracker.service;

import com.hanrry.studytracker.dto.StudySessionRequestDTO;
import com.hanrry.studytracker.dto.StudySessionResponseDTO;
import com.hanrry.studytracker.dto.UpdateStudySessionRequestDTO;
import com.hanrry.studytracker.entity.Lesson;
import com.hanrry.studytracker.entity.StudySession;
import com.hanrry.studytracker.entity.User;
import com.hanrry.studytracker.exception.ResourceNotFoundException;
import com.hanrry.studytracker.mapper.StudySessionMapper;
import com.hanrry.studytracker.repository.LessonRepository;
import com.hanrry.studytracker.repository.StudySessionRepository;
import com.hanrry.studytracker.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudySessionService {


    private final StudySessionRepository studySessionRepository;
    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;
    private final StudySessionMapper studySessionMapper;

    public StudySessionService(
            StudySessionRepository studySessionRepository,
            UserRepository userRepository,
            LessonRepository lessonRepository,
            StudySessionMapper studySessionMapper
    ) {
        this.studySessionRepository = studySessionRepository;
        this.userRepository = userRepository;
        this.lessonRepository = lessonRepository;
        this.studySessionMapper = studySessionMapper;
    }

    public StudySessionResponseDTO createStudySession(StudySessionRequestDTO request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User not found with id: " + request.userId()));

        Lesson lesson = null;
        if (request.lessonId() != null) {
            lesson = lessonRepository.findById(request.lessonId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Lesson not found with id: " + request.lessonId()));
        }

        StudySession studySession = new StudySession();
        studySession.setUser(user);
        studySession.setLesson(lesson);
        studySession.setDurationMinutes(request.durationMinutes());
        studySession.setNotes(request.notes());
        studySession.setStudiedAt(request.studiedAt());

        StudySession savedStudySession = studySessionRepository.save(studySession);

        return studySessionMapper.toDTO(savedStudySession);
    }

    public StudySessionResponseDTO findStudySessionById(Long id) {
        StudySession studySession = studySessionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Study session not found with id: " + id));

        return studySessionMapper.toDTO(studySession);
    }

    public Page<StudySessionResponseDTO> findAllStudySessions(Pageable pageable) {
        Page<StudySession> studySessionPage = studySessionRepository.findAll(pageable);
        return studySessionPage.map(studySessionMapper::toDTO);
    }

    public StudySessionResponseDTO updateStudySession(Long id, UpdateStudySessionRequestDTO request) {
        StudySession studySession = studySessionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Study session not found with id: " + id));

        if (request.lessonId() != null) {
            Lesson lesson = lessonRepository.findById(request.lessonId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Lesson not found with id: " + request.lessonId()));
            studySession.setLesson(lesson);
        }

        if (request.durationMinutes() != null) {
            studySession.setDurationMinutes(request.durationMinutes());
        }

        if (request.notes() != null) {
            studySession.setNotes(request.notes());
        }

        if (request.studiedAt() != null) {
            studySession.setStudiedAt(request.studiedAt());
        }

        StudySession savedStudySession = studySessionRepository.save(studySession);

        return studySessionMapper.toDTO(savedStudySession);
    }

    public void deleteStudySession(Long id) {
        findStudySessionById(id);
        studySessionRepository.deleteById(id);
    }
}
