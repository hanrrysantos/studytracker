package com.hanrry.studytracker.service;

import com.hanrry.studytracker.dto.CreateCategoryRequestDTO;
import com.hanrry.studytracker.dto.CreateCategoryResponseDTO;
import com.hanrry.studytracker.dto.UpdateCategoryRequestDTO;
import com.hanrry.studytracker.entity.Category;
import com.hanrry.studytracker.entity.User;
import com.hanrry.studytracker.exception.ResourceNotFoundException;
import com.hanrry.studytracker.mapper.CategoryMapper;
import com.hanrry.studytracker.repository.CategoryRepository;
import com.hanrry.studytracker.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, UserRepository userRepository, CategoryMapper categoryMapper){
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    //createCategory
    public CreateCategoryResponseDTO createCategory(CreateCategoryRequestDTO request){
        User user = userRepository.findById(request.userId()).orElseThrow(
                () -> new ResourceNotFoundException("User not found with id: " + request.userId())
        );

        Category category = categoryMapper.toEntity(request);
        category.setUser(user);
        category.setCreatedAt(LocalDateTime.now());

        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.toDTO(savedCategory);
    }

    //findCategoryById
    public CreateCategoryResponseDTO findCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category not found with id: " + id)
        );

        return categoryMapper.toDTO(category);
    }

    //findAllCategory
    public Page<CreateCategoryResponseDTO> findAllCategories(Pageable pageable){
        Page<Category> categoriesPage = categoryRepository.findAll(pageable);

        return categoriesPage.map(categoryMapper::toDTO);
    }

    //updateCategory
    public CreateCategoryResponseDTO updateCategory(Long id, UpdateCategoryRequestDTO request){
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category not found with id: " + id)
        );

        category.setName(request.name());
        category.setDescription(request.description());

        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.toDTO(savedCategory);
    }

    //deleteCategoryById
    public void deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
    }
}
