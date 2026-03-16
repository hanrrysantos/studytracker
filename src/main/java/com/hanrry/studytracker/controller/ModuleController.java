package com.hanrry.studytracker.controller;

import com.hanrry.studytracker.controller.docs.ModuleControllerDocs;
import com.hanrry.studytracker.dto.ModuleRequestDTO;
import com.hanrry.studytracker.dto.ModuleResponseDTO;
import com.hanrry.studytracker.dto.UpdateModuleRequestDTO;
import com.hanrry.studytracker.service.ModuleService;
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
@RequestMapping(value = "/api/v1/modules")
public class ModuleController implements ModuleControllerDocs {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService){
        this.moduleService = moduleService;
    }

    @PostMapping
    @Override
    public ResponseEntity<ModuleResponseDTO> createModule(
            @Valid
            @RequestBody ModuleRequestDTO request
    ){
        ModuleResponseDTO module = moduleService.createModule(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(module.id()).toUri();
        return ResponseEntity.created(uri).body(module);
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<ModuleResponseDTO> findModuleById(
            @PathVariable("id") Long id
    ){
        ModuleResponseDTO module = moduleService.findModuleById(id);
        return ResponseEntity.ok().body(module);
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<ModuleResponseDTO>> findAllModules(
            @ParameterObject
            @PageableDefault(size = 5, sort = "id")
            Pageable pageable
    ){
        Page<ModuleResponseDTO> modulePage = moduleService.findAllModules(pageable);
        return ResponseEntity.ok().body(modulePage);
    }

    @PutMapping(value = "/{id}")
    @Override
    public ResponseEntity<ModuleResponseDTO> updateModule(
            @PathVariable("id") Long id,
            @Valid
            @RequestBody UpdateModuleRequestDTO request
    ){
        ModuleResponseDTO module = moduleService.updateModule(id, request);
        return ResponseEntity.ok().body(module);
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<Void> deleteModule(
            @PathVariable("id") Long id
    ){
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }
}
