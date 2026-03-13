package com.hanrry.studytracker.controller;

import com.hanrry.studytracker.dto.*;
import com.hanrry.studytracker.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CreateCategoryResponseDTO> createCategory(
            @Valid
            @RequestBody
            CreateCategoryRequestDTO request){

        CreateCategoryResponseDTO category = categoryService.createCategory(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(category.id()).toUri();
        return ResponseEntity.created(uri).body(category);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CreateCategoryResponseDTO> findCategoryById(@PathVariable  Long id){

        CreateCategoryResponseDTO category = categoryService.findCategoryById(id);

        return ResponseEntity.ok().body(category);

    }

    @GetMapping
    public ResponseEntity<Page<CreateCategoryResponseDTO>> listAllCategories(
            @PageableDefault(size = 10, page = 0, sort = "id")
            Pageable pageable){

        Page<CreateCategoryResponseDTO> categoriesPages = categoryService.findAllCategories(pageable);

        return ResponseEntity.ok().body(categoriesPages);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CreateCategoryResponseDTO> updateCategory(
            @PathVariable Long id,
            @Valid
            @RequestBody UpdateCategoryRequestDTO request){

        CreateCategoryResponseDTO category = categoryService.updateCategory(id, request);

        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
