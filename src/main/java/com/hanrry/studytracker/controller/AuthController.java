package com.hanrry.studytracker.controller;

import com.hanrry.studytracker.controller.docs.AuthControllerDocs;
import com.hanrry.studytracker.dto.AuthRequestDTO;
import com.hanrry.studytracker.dto.AuthResponseDTO;
import com.hanrry.studytracker.dto.UserRequestDTO;
import com.hanrry.studytracker.dto.UserResponseDTO;
import com.hanrry.studytracker.security.JwtUtil;
import com.hanrry.studytracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController implements AuthControllerDocs {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserService userService){
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponseDTO> login(
            @RequestBody
            @Valid AuthRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        String token = jwtUtil.generateToken(request.email());

        return ResponseEntity.ok().body(new AuthResponseDTO(token));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserResponseDTO> register(
            @Valid
            @RequestBody UserRequestDTO dto
    ){
        UserResponseDTO user = userService.createUser(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/users/{id}")
                .buildAndExpand(user.id()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
}
