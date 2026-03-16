package com.hanrry.studytracker.mapper;

import com.hanrry.studytracker.dto.LessonProgressRequestDTO;
import com.hanrry.studytracker.dto.LessonProgressResponseDTO;
import com.hanrry.studytracker.entity.LessonProgress;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonProgressMapper {

    LessonProgress ToEntity(LessonProgressRequestDTO request);

    LessonProgressResponseDTO toDTO(LessonProgress entity);

    List<LessonProgressResponseDTO> toDTOList(List<LessonProgress> progressList);


}
