package com.hanrry.studytracker.controller;

import com.hanrry.studytracker.dto.*;
import com.hanrry.studytracker.service.LessonService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService){
        this.lessonService = lessonService;
    }

    //create
    @PostMapping
    public ResponseEntity<LessonResponseDTO> createLesson(
            @Valid
            @RequestBody LessonRequestDTO request
    ){
        LessonResponseDTO lesson = lessonService.createLesson(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(lesson.id()).toUri();
        return ResponseEntity.created(uri).body(lesson);
    }

    //findOne
    @GetMapping(value = "/{id}")
    public ResponseEntity<LessonResponseDTO> findLessonById(
            @PathVariable Long id
    ){
        LessonResponseDTO course = lessonService.findLessonById(id);

        return ResponseEntity.ok().body(course);
    }

    //findAll
    @GetMapping
    public ResponseEntity<Page<LessonResponseDTO>> findAllLessons(
            @PageableDefault(size = 10, page = 0, sort = "id")
            Pageable pageable
    ){
        Page<LessonResponseDTO> course = lessonService.findAllLessons(pageable);

        return ResponseEntity.ok().body(course);
    }

    //update
    @PutMapping(value = "/{id}")
    public ResponseEntity<LessonResponseDTO> updateLessons(
            @PathVariable Long id,
            @Valid
            @RequestBody UpdateLessonRequestDTO request
    ){
        LessonResponseDTO course = lessonService.updateLesson(id, request);

        return ResponseEntity.ok().body(course);
    }

    //delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteLessons(@PathVariable Long id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }
}
