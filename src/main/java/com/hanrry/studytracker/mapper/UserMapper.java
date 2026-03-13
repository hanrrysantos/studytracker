package com.hanrry.studytracker.mapper;

import com.hanrry.studytracker.dto.UserRequestDTO;
import com.hanrry.studytracker.dto.UserResponseDTO;
import com.hanrry.studytracker.dto.UpdateUserRequestDTO;
import com.hanrry.studytracker.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequestDTO userRequestDTO);

    UserResponseDTO toDTO(User user);

    List<UserResponseDTO> toDTOList(List<User> users);

    User updateToEntity(UpdateUserRequestDTO updateUserRequestDTO);
}
