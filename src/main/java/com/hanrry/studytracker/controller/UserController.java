package com.hanrry.studytracker.controller;

import com.hanrry.studytracker.controller.docs.UserControllerDocs;
import com.hanrry.studytracker.dto.UserResponseDTO;
import com.hanrry.studytracker.dto.UpdateUserRequestDTO;
import com.hanrry.studytracker.service.UserService;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController implements UserControllerDocs {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<UserResponseDTO> findUserById(
            @PathVariable("id") Long id
    ) {
        UserResponseDTO user = userService.findUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<UserResponseDTO>> findAllUsers(
            @ParameterObject
            @PageableDefault(size = 5, sort = "id")
            Pageable pageable
    ){
        Page<UserResponseDTO> listAllUsers = userService.findAllUsers(pageable);
        return ResponseEntity.ok().body(listAllUsers);
    }

    @PutMapping(value = "/{id}")
    @Override
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable("id") Long id,
            @Valid
            @RequestBody UpdateUserRequestDTO requestDTO
    ){
        UserResponseDTO user = userService.updateUser(id, requestDTO);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<Void> deleteUser(
            @PathVariable("id") Long id
    ){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}