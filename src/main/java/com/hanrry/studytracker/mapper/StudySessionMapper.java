package com.hanrry.studytracker.mapper;

import com.hanrry.studytracker.dto.LessonProgressRequestDTO;
import com.hanrry.studytracker.dto.LessonProgressResponseDTO;
import com.hanrry.studytracker.dto.StudySessionRequestDTO;
import com.hanrry.studytracker.dto.StudySessionResponseDTO;
import com.hanrry.studytracker.entity.LessonProgress;
import com.hanrry.studytracker.entity.StudySession;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudySessionMapper {

    StudySession ToEntity(StudySessionRequestDTO request);

    StudySessionResponseDTO toDTO(StudySession entity);

    List<StudySessionResponseDTO> toDTOList(List<StudySessionResponseDTO> sessionResponseDTOList);


}
