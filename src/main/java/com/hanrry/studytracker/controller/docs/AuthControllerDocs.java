package com.hanrry.studytracker.controller.docs;

import com.hanrry.studytracker.dto.AuthRequestDTO;
import com.hanrry.studytracker.dto.AuthResponseDTO;
import com.hanrry.studytracker.dto.UserRequestDTO;
import com.hanrry.studytracker.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Autenticação", description = "Endpoints públicos para login e registo de novos utilizadores")
public interface AuthControllerDocs {

    @Operation(summary = "Autentica um utilizador",
            description = "Verifica as credenciais do utilizador e retorna um token JWT para acesso às rotas protegidas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso (Token JWT retornado)"),
            @ApiResponse(responseCode = "400", description = "Erro de validação - Email ou senha em formato inválidos"),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas (E-mail ou senha incorretos)")
    })
    ResponseEntity<AuthResponseDTO> login(AuthRequestDTO request);

    @Operation(summary = "Regista um novo utilizador",
            description = "Cria uma nova conta de utilizador no sistema com a permissão padrão de 'USER'.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Utilizador registado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados"),
            @ApiResponse(responseCode = "409", description = "Já existe um utilizador registado com este e-mail")
    })
    ResponseEntity<UserResponseDTO> register(UserRequestDTO dto);
}