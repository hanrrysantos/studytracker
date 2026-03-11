package com.hanrry.studytracker.repository;

import com.hanrry.studytracker.entity.Course;
import com.hanrry.studytracker.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
