package com.hanrry.studytracker.service;

import com.hanrry.studytracker.dto.CourseRequestDTO;
import com.hanrry.studytracker.dto.CourseResponseDTO;
import com.hanrry.studytracker.dto.UpdateCourseRequestDTO;
import com.hanrry.studytracker.entity.Category;
import com.hanrry.studytracker.entity.Course;
import com.hanrry.studytracker.entity.User;
import com.hanrry.studytracker.exception.ResourceNotFoundException;
import com.hanrry.studytracker.mapper.CourseMapper;
import com.hanrry.studytracker.repository.CategoryRepository;
import com.hanrry.studytracker.repository.CourseRepository;
import com.hanrry.studytracker.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.hanrry.studytracker.entity.CourseStatus.PLANNED;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final CourseMapper courseMapper;

    public CourseService(
            CourseRepository courseRepository,UserRepository userRepository,
            CategoryRepository categoryRepository, CourseMapper courseMapper
    ){
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.courseMapper = courseMapper;
    }

    public CourseResponseDTO createCourse(CourseRequestDTO request){
        User user = userRepository.findById(request.userId()).orElseThrow(
                () -> new ResourceNotFoundException("User not found with id: " + request.userId())
        );

        Category category = categoryRepository.findById(request.categoryId()).orElseThrow(
                () -> new ResourceNotFoundException("Category not found with id: " + request.categoryId())
        );

        if(!category.getUser().getId().equals(user.getId())){
            throw new IllegalArgumentException("Category does not belong to this user");
        }

        Course course = courseMapper.toEntity(request);
        course.setCategory(category);
        course.setUser(user);
        course.setStatus(PLANNED);
        course.setCreatedAt(LocalDateTime.now());
        course.setUpdatedAt(LocalDateTime.now());

        Course savedCourse = courseRepository.save(course);

        return courseMapper.toDTO(savedCourse);
    }

    public CourseResponseDTO findCourseById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course not found with id: " + id)
        );

        return courseMapper.toDTO(course);
    }

    public Page<CourseResponseDTO> findAllCourses(Pageable pageable){
        Page<Course> coursePage = courseRepository.findAll(pageable);

        return coursePage.map(courseMapper::toDTO);
    }

    public CourseResponseDTO updateCourse(Long id, UpdateCourseRequestDTO request){
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course not found with id: " + id)
        );

        course.setTitle(request.title());
        course.setDescription((request.description()));
        course.setStatus(request.status());

        if(request.categoryId() != null){
            Category category = categoryRepository.findById(request.categoryId()).orElseThrow(
                    () -> new ResourceNotFoundException("Category not found with id: " + request.categoryId())
            );
            course.setCategory(category);
        }

        course.setUpdatedAt(LocalDateTime.now());

        Course savedCourse = courseRepository.save(course);

        return courseMapper.toDTO(savedCourse);
    }

    public void deleteById(Long id){
        findCourseById(id);
        courseRepository.deleteById(id);
    }
}
