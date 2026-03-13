package com.hanrry.studytracker.mapper;

import com.hanrry.studytracker.dto.CreateUserRequestDTO;
import com.hanrry.studytracker.dto.CreateUserResponseDTO;
import com.hanrry.studytracker.dto.UpdateUserRequestDTO;
import com.hanrry.studytracker.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(CreateUserRequestDTO createUserRequestDTO);

    CreateUserResponseDTO toDTO(User user);

    List<CreateUserResponseDTO> toDTOList(List<User> users);

    User updateToEntity(UpdateUserRequestDTO updateUserRequestDTO);
}
