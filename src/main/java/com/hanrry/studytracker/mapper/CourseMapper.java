package com.hanrry.studytracker.mapper;

import com.hanrry.studytracker.dto.CreateCourseRequestDTO;
import com.hanrry.studytracker.dto.CreateCourseResponseDTO;
import com.hanrry.studytracker.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toEntity(CreateCourseRequestDTO request);

    CreateCourseResponseDTO toDTO(Course course);

    List<CreateCourseResponseDTO> toDTOList(List<Course> requestDTOList);

}
