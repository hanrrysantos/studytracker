package com.hanrry.studytracker.repository;

import com.hanrry.studytracker.entity.StudySession;
import com.hanrry.studytracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudySessionRepository extends JpaRepository<StudySession, Long> {
    List<StudySession> findByUserId(Long userId);
}
