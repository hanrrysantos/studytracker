package com.hanrry.studytracker.controller;

import com.hanrry.studytracker.controller.docs.CategoryControllerDocs;
import com.hanrry.studytracker.dto.*;
import com.hanrry.studytracker.service.CategoryService;
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
@RequestMapping(value = "/api/v1/categories")
public class CategoryController implements CategoryControllerDocs {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    @Override
    public ResponseEntity<CategoryResponseDTO> createCategory(
            @Valid
            @RequestBody
            CategoryRequestDTO request){

        CategoryResponseDTO category = categoryService.createCategory(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(category.id()).toUri();
        return ResponseEntity.created(uri).body(category);
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<CategoryResponseDTO> findCategoryById(
            @PathVariable("id")  Long id
    ){
        CategoryResponseDTO category = categoryService.findCategoryById(id);

        return ResponseEntity.ok().body(category);

    }

    @GetMapping
    @Override
    public ResponseEntity<Page<CategoryResponseDTO>> listAllCategories(
            @ParameterObject
            @PageableDefault(size = 5, sort = "id")
            Pageable pageable
    ){
        Page<CategoryResponseDTO> categoriesPages = categoryService.findAllCategories(pageable);

        return ResponseEntity.ok().body(categoriesPages);
    }

    @PutMapping(value = "/{id}")
    @Override
    public ResponseEntity<CategoryResponseDTO> updateCategory(
            @PathVariable("id") Long id,
            @Valid
            @RequestBody UpdateCategoryRequestDTO request){

        CategoryResponseDTO category = categoryService.updateCategory(id, request);

        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<Void> deleteCategoryById(
            @PathVariable("id") Long id
    ){
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
