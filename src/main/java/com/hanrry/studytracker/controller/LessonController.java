package com.hanrry.studytracker.controller;

import com.hanrry.studytracker.controller.docs.LessonControllerDocs;
import com.hanrry.studytracker.dto.*;
import com.hanrry.studytracker.service.LessonService;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/lessons")
public class LessonController implements LessonControllerDocs {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService){
        this.lessonService = lessonService;
    }

    @PostMapping
    @Override
    public ResponseEntity<LessonResponseDTO> createLesson(
            @Valid
            @RequestBody LessonRequestDTO request
    ){
        LessonResponseDTO lesson = lessonService.createLesson(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(lesson.id()).toUri();
        return ResponseEntity.created(uri).body(lesson);
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<LessonResponseDTO> findLessonById(
            @PathVariable("id") Long id
    ){
        LessonResponseDTO lesson = lessonService.findLessonById(id);

        return ResponseEntity.ok().body(lesson);
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<LessonResponseDTO>> findAllLessons(
            @ParameterObject
            @PageableDefault(size = 5, sort = "id")
            Pageable pageable
    ){
        Page<LessonResponseDTO> lessonPage = lessonService.findAllLessons(pageable);

        return ResponseEntity.ok().body(lessonPage);
    }

    @PutMapping(value = "/{id}")
    @Override
    public ResponseEntity<LessonResponseDTO> updateLessons(
            @PathVariable("id") Long id,
            @Valid
            @RequestBody UpdateLessonRequestDTO request
    ){
        LessonResponseDTO lesson = lessonService.updateLesson(id, request);

        return ResponseEntity.ok().body(lesson);
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<Void> deleteLessons(
            @PathVariable("id") Long id
    ) {
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }
}
