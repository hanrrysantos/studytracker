package com.hanrry.studytracker.controller;

import com.hanrry.studytracker.dto.LessonProgressRequestDTO;
import com.hanrry.studytracker.dto.LessonProgressResponseDTO;
import com.hanrry.studytracker.service.LessonProgressService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/lesson-progress")
public class LessonProgressController {

    private final LessonProgressService lessonProgressService;

    public LessonProgressController(LessonProgressService lessonProgressService){
        this.lessonProgressService = lessonProgressService;
    }

    @PostMapping(value = "/complete")
    public ResponseEntity<LessonProgressResponseDTO> completeLesson(
            @Valid
            @RequestBody LessonProgressRequestDTO request){
        LessonProgressResponseDTO lesson = lessonProgressService.completeLesson(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(lesson.id()).toUri();
        return ResponseEntity.created(uri).body(lesson);
    }

    @PostMapping(value = "/uncomplete")
    public ResponseEntity<LessonProgressResponseDTO> unCompleteLesson(
            @Valid
            @RequestBody LessonProgressRequestDTO request){
        LessonProgressResponseDTO lesson = lessonProgressService.unCompleteLesson(request);
        return ResponseEntity.ok().body(lesson);
    }

    @GetMapping
    public ResponseEntity<LessonProgressResponseDTO> findProgress(
            @RequestParam Long userId,
            @RequestParam Long lessonId
    ){
        LessonProgressResponseDTO lesson = lessonProgressService.findProgress(userId, lessonId);
        return ResponseEntity.ok().body(lesson);
    }
}
