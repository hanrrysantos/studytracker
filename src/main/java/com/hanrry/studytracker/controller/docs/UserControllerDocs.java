package com.hanrry.studytracker.controller.docs;

import com.hanrry.studytracker.dto.UserResponseDTO;
import com.hanrry.studytracker.dto.UpdateUserRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Tag(name = "Usuários", description = "Endpoints para gerenciamento de usuários do sistema")
public interface UserControllerDocs {

    @Operation(summary = "Busca um usuário pelo ID", description = "Retorna as informações detalhadas de um usuário específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Token inválido ou expirado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
        ResponseEntity<UserResponseDTO> findUserById(
                Long id
    );

    @Operation(summary = "Lista todos os usuários", description = "Retorna uma lista paginada de todos os usuários cadastrados. Requer permissão de ADMIN.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista recuperada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado (Requer role ADMIN)")
    })
    ResponseEntity<Page<UserResponseDTO>> findAllUsers(
            Pageable pageable
    );

    @Operation(summary = "Atualiza um usuário", description = "Atualiza o nome ou a senha de um usuário existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados"),
            @ApiResponse(responseCode = "403", description = "Acesso negado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    ResponseEntity<UserResponseDTO> updateUser(
            Long id,
            UpdateUserRequestDTO requestDTO
    );

    @Operation(summary = "Exclui um usuário", description = "Remove um usuário do banco de dados pelo seu ID. Requer permissão de ADMIN.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário excluído com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado (Requer role ADMIN)"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    ResponseEntity<Void> deleteUser(
            Long id
    );
}