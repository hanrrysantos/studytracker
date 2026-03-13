package com.hanrry.studytracker.mapper;

import com.hanrry.studytracker.dto.CreateCategoryRequestDTO;
import com.hanrry.studytracker.dto.CreateCategoryResponseDTO;
import com.hanrry.studytracker.dto.CreateCourseRequestDTO;
import com.hanrry.studytracker.dto.UpdateCategoryRequestDTO;
import com.hanrry.studytracker.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CreateCategoryRequestDTO categoryRequestDTO);

    CreateCategoryResponseDTO toDTO(Category category);

    List<CreateCategoryResponseDTO> toDTOList(List<Category> categoryList);

    Category updateToEntity(UpdateCategoryRequestDTO updateCategoryRequestDTO);
}
