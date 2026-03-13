package com.hanrry.studytracker.mapper;

import com.hanrry.studytracker.dto.ModuleRequestDTO;
import com.hanrry.studytracker.dto.ModuleResponseDTO;
import org.mapstruct.Mapper;
import com.hanrry.studytracker.entity.Module;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModuleMapper {

    Module toEntity(ModuleRequestDTO request);

    ModuleResponseDTO toDTO(Module module);

    List<ModuleResponseDTO> toDTOList(List<Module> modules);

}
