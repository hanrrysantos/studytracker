package com.hanrry.studytracker.controller;

import com.hanrry.studytracker.dto.CourseRequestDTO;
import com.hanrry.studytracker.dto.CourseResponseDTO;
import com.hanrry.studytracker.dto.UpdateCourseRequestDTO;
import com.hanrry.studytracker.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseResponseDTO> createCourse(
            @Valid
            @RequestBody CourseRequestDTO request
    ){
        CourseResponseDTO course = courseService.createCourse(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(course.id()).toUri();
        return ResponseEntity.created(uri).body(course);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseResponseDTO> findCourseById(
            @PathVariable Long id
    ){
        CourseResponseDTO course = courseService.findCourseById(id);

        return ResponseEntity.ok().body(course);
    }

    @GetMapping
    public ResponseEntity<Page<CourseResponseDTO>> findAllCourses(
            @PageableDefault(size = 10, page = 0, sort = "id")
            Pageable pageable
    ){
        Page<CourseResponseDTO> course = courseService.findAllCourses(pageable);

        return ResponseEntity.ok().body(course);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(
            @PathVariable Long id,
            @Valid
            @RequestBody UpdateCourseRequestDTO request
    ){
        CourseResponseDTO course = courseService.updateCourse(id, request);

        return ResponseEntity.ok().body(course);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
