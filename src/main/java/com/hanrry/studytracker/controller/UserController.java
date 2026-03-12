package com.hanrry.studytracker.controller;

import com.hanrry.studytracker.dto.CreateUserRequestDTO;
import com.hanrry.studytracker.dto.CreateUserResponseDTO;
import com.hanrry.studytracker.dto.UpdateUserRequestDTO;
import com.hanrry.studytracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseDTO> createUser(
            @Valid
            @RequestBody CreateUserRequestDTO dto
        ){
        CreateUserResponseDTO user = userService.createUser(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.id()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CreateUserResponseDTO> findUserById(
            @PathVariable Long id
    ){
        CreateUserResponseDTO user = userService.findUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<Page<CreateUserResponseDTO>> findAllUsers(
            @PageableDefault(size = 10, page = 0, sort = "id")
            Pageable pageable
    ){
        Page<CreateUserResponseDTO> listAllUsers = userService.findAllUsers(pageable);
        return ResponseEntity.ok().body(listAllUsers);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CreateUserResponseDTO> updateUser(
            @PathVariable Long id,
            @Valid
            @RequestBody UpdateUserRequestDTO requestDTO
    ){
        CreateUserResponseDTO user = userService.updateUser(id, requestDTO);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
