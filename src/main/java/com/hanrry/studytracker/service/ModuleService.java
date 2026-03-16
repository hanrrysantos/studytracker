package com.hanrry.studytracker.service;

import com.hanrry.studytracker.dto.ModuleRequestDTO;
import com.hanrry.studytracker.dto.ModuleResponseDTO;
import com.hanrry.studytracker.dto.UpdateModuleRequestDTO;
import com.hanrry.studytracker.entity.Course;
import com.hanrry.studytracker.entity.Module;
import com.hanrry.studytracker.exception.ResourceNotFoundException;
import com.hanrry.studytracker.mapper.ModuleMapper;
import com.hanrry.studytracker.repository.CourseRepository;
import com.hanrry.studytracker.repository.ModuleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ModuleService {

    private final ModuleMapper moduleMapper;
    private final ModuleRepository moduleRepository;
    private final CourseRepository courseRepository;

    public ModuleService(ModuleMapper moduleMapper, ModuleRepository moduleRepository, CourseRepository courseRepository){
        this.moduleMapper = moduleMapper;
        this.moduleRepository = moduleRepository;
        this.courseRepository = courseRepository;
    }

    public ModuleResponseDTO createModule(ModuleRequestDTO request){
        Course course = courseRepository.findById(request.courseId()).orElseThrow(
                () -> new ResourceNotFoundException("Course not found with id: " + request.courseId())
        );

        Module module = moduleMapper.toEntity(request);

        module.setCourse(course);
        module.setCreatedAt(LocalDateTime.now());

        Module savedModule = moduleRepository.save(module);

        return moduleMapper.toDTO(savedModule);
    }

    public ModuleResponseDTO findModuleById(Long id){
        Module module = moduleRepository.findById(id).orElseThrow(
                () ->  new ResourceNotFoundException("Module not found with id: " + id)
        );

        return moduleMapper.toDTO(module);
    }

    public Page<ModuleResponseDTO> findAllModules(Pageable pageable){
        Page<Module> modulePage = moduleRepository.findAll(pageable);

        return modulePage.map(moduleMapper::toDTO);
    }

    public ModuleResponseDTO updateModule(Long id, UpdateModuleRequestDTO request){
        Module module = moduleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Module not found with id: " + id)
        );

        module.setTitle(request.title());
        module.setDescription(request.description());
        module.setPosition(request.position());

        Module savedModule = moduleRepository.save(module);

        return moduleMapper.toDTO(savedModule);
    }

    public void deleteModule(Long id){
        findModuleById(id);
        moduleRepository.deleteById(id);
    }
}
