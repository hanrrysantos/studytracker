package com.hanrry.studytracker.controller;

import com.hanrry.studytracker.dto.StudySessionRequestDTO;
import com.hanrry.studytracker.dto.StudySessionResponseDTO;
import com.hanrry.studytracker.dto.UpdateStudySessionRequestDTO;
import com.hanrry.studytracker.service.StudySessionService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "api/v1/study-sessions")
public class StudySessionController {

    private final StudySessionService studySessionService;

    public StudySessionController(StudySessionService studySessionService) {
        this.studySessionService = studySessionService;
    }

    @PostMapping
    public ResponseEntity<StudySessionResponseDTO> createStudySession(
            @Valid
            @RequestBody StudySessionRequestDTO request
    ) {
        StudySessionResponseDTO studySession = studySessionService.createStudySession(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(studySession.id()).toUri();
        return ResponseEntity.created(uri).body(studySession);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudySessionResponseDTO> findStudySessionById(
            @PathVariable Long id
    ) {
        StudySessionResponseDTO studySession = studySessionService.findStudySessionById(id);
        return ResponseEntity.ok().body(studySession);
    }

    @GetMapping
    public ResponseEntity<Page<StudySessionResponseDTO>> findAllStudySessions(
            @PageableDefault(size = 10, page = 0, sort = "id")
            Pageable pageable
    ) {
        Page<StudySessionResponseDTO> studySessions = studySessionService.findAllStudySessions(pageable);

        return ResponseEntity.ok().body(studySessions);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StudySessionResponseDTO> updateStudySession(
            @PathVariable Long id,
            @Valid
            @RequestBody UpdateStudySessionRequestDTO request
    ) {
        StudySessionResponseDTO studySession = studySessionService.updateStudySession(id, request);
        return ResponseEntity.ok().body(studySession);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteStudySession(
            @PathVariable Long id
    ) {
        studySessionService.deleteStudySession(id);
        return ResponseEntity.noContent().build();
    }
}
