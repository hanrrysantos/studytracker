package com.hanrry.studytracker.mapper;

import com.hanrry.studytracker.dto.CourseRequestDTO;
import com.hanrry.studytracker.dto.CourseResponseDTO;
import com.hanrry.studytracker.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toEntity(CourseRequestDTO request);

    CourseResponseDTO toDTO(Course course);

    List<CourseResponseDTO> toDTOList(List<Course> requestDTOList);

}
