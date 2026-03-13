package com.hanrry.studytracker.controller;

import com.hanrry.studytracker.dto.ModuleRequestDTO;
import com.hanrry.studytracker.dto.ModuleResponseDTO;
import com.hanrry.studytracker.dto.UpdateModuleRequestDTO;
import com.hanrry.studytracker.service.ModuleService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/modules")
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService){
        this.moduleService = moduleService;
    }

    //create
    @PostMapping
    public ResponseEntity<ModuleResponseDTO> createModule(
            @Valid
            @RequestBody ModuleRequestDTO request
    ){
        ModuleResponseDTO module = moduleService.createModule(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(module.id()).toUri();
        return ResponseEntity.created(uri).body(module);
    }

    //findById
    @GetMapping(value = "/{id}")
    public ResponseEntity<ModuleResponseDTO> findModuleById(
            @PathVariable Long id
    ){
        ModuleResponseDTO module = moduleService.findModuleById(id);
        return ResponseEntity.ok().body(module);
    }

    //findAll
    @GetMapping
    public ResponseEntity<Page<ModuleResponseDTO>> findAllModules(
            @PageableDefault(size = 10, page = 0, sort = "id")
            Pageable pageable
    ){
        Page<ModuleResponseDTO> modulePage = moduleService.findAllModules(pageable);
        return ResponseEntity.ok().body(modulePage);
    }

    //update
    @PutMapping(value = "/{id}")
    public ResponseEntity<ModuleResponseDTO> updateModule(
            @PathVariable Long id,
            @Valid
            @RequestBody UpdateModuleRequestDTO request
    ){
        ModuleResponseDTO module = moduleService.updateModule(id, request);
        return ResponseEntity.ok().body(module);
    }

    //delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteModule(
            @PathVariable Long id
    ){
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }
}
