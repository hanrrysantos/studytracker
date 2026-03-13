package com.hanrry.studytracker.mapper;

import com.hanrry.studytracker.dto.LessonRequestDTO;
import com.hanrry.studytracker.dto.LessonResponseDTO;
import com.hanrry.studytracker.entity.Lesson;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    Lesson toEntity(LessonRequestDTO request);

    LessonResponseDTO toDTO(Lesson lesson);

    List<LessonResponseDTO> toDTOList(List<Lesson> lessons);

}
