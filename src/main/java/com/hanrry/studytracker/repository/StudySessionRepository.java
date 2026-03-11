package com.hanrry.studytracker.repository;

import com.hanrry.studytracker.entity.StudySession;
import com.hanrry.studytracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudySessionRepository extends JpaRepository<StudySession, Long> {
}
