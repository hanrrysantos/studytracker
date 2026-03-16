package com.hanrry.studytracker.repository;

import com.hanrry.studytracker.entity.LessonProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LessonProgressRepository extends JpaRepository<LessonProgress, Long> {

    Optional<LessonProgress> findByUserIdAndLessonId(Long UserId, Long LessonId);

    long countByUserIdAndCompletedTrue(Long userId);

    long countByUserIdAndCompletedFalse(Long userId);

}
