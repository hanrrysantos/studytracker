package com.hanrry.studytracker.service;

import com.hanrry.studytracker.dto.LessonRequestDTO;
import com.hanrry.studytracker.dto.LessonResponseDTO;
import com.hanrry.studytracker.dto.UpdateLessonRequestDTO;
import com.hanrry.studytracker.entity.Lesson;
import com.hanrry.studytracker.entity.Module;
import com.hanrry.studytracker.exception.ResourceNotFoundException;
import com.hanrry.studytracker.mapper.LessonMapper;
import com.hanrry.studytracker.repository.LessonRepository;
import com.hanrry.studytracker.repository.ModuleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LessonService {

    private final LessonMapper lessonMapper;
    private final ModuleRepository moduleRepository;
    private final LessonRepository lessonRepository;

    public LessonService(LessonMapper lessonMapper, ModuleRepository moduleRepository, LessonRepository lessonRepository){
        this.lessonMapper = lessonMapper;
        this.moduleRepository = moduleRepository;
        this.lessonRepository = lessonRepository;
    }

    public LessonResponseDTO createLesson(LessonRequestDTO request){
        Module module = moduleRepository.findById(request.moduleId()).orElseThrow(
                () -> new ResourceNotFoundException("Module not found with id: " + request.moduleId())
        );

        Lesson lesson = lessonMapper.toEntity(request);
        lesson.setModule(module);
        lesson.setCreatedAt(LocalDateTime.now());

        Lesson savedLesson = lessonRepository.save(lesson);

        return lessonMapper.toDTO(savedLesson);
    }

    public LessonResponseDTO findLessonById(Long id){
        Lesson lesson = lessonRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Lesson not found with id: " + id)
        );

        return lessonMapper.toDTO(lesson);
    }

    public Page<LessonResponseDTO> findAllLessons(Pageable pageable){
        Page<Lesson> lessonPage = lessonRepository.findAll(pageable);

        return lessonPage.map(lessonMapper::toDTO);
    }

    public LessonResponseDTO updateLesson(Long id, UpdateLessonRequestDTO request){
        Lesson lesson = lessonRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Lesson not found with id: " + id)
        );

        lesson.setTitle(request.title());
        lesson.setDescription(request.description());
        lesson.setLessonUrl(request.lessonUrl());
        lesson.setEstimatedMinutes(request.estimatedMinutes());
        lesson.setPosition(request.position());

        Lesson savedLesson = lessonRepository.save(lesson);

        return lessonMapper.toDTO(savedLesson);
    }

    public void deleteLesson(Long id){
        findLessonById(id);
        lessonRepository.deleteById(id);
    }
}
