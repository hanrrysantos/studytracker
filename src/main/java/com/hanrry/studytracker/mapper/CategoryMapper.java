package com.hanrry.studytracker.mapper;

import com.hanrry.studytracker.dto.CategoryRequestDTO;
import com.hanrry.studytracker.dto.CategoryResponseDTO;
import com.hanrry.studytracker.dto.UpdateCategoryRequestDTO;
import com.hanrry.studytracker.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryRequestDTO categoryRequestDTO);

    CategoryResponseDTO toDTO(Category category);

    List<CategoryResponseDTO> toDTOList(List<Category> categoryList);

    Category updateToEntity(UpdateCategoryRequestDTO updateCategoryRequestDTO);
}
