package com.hanrry.studytracker.repository;

import com.hanrry.studytracker.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
