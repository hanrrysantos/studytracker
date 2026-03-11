package com.hanrry.studytracker.repository;

import com.hanrry.studytracker.entity.Course;
import com.hanrry.studytracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
