package com.hanrry.studytracker.repository;

import com.hanrry.studytracker.entity.LessonProgres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonProgressRepository extends JpaRepository<LessonProgres, Long> {
}
