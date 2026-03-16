package com.hanrry.studytracker.controller.docs;

import com.hanrry.studytracker.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Tag(name = "Sessão de Estudo", description = "Endpoints para gerenciamento de sessões de estudo do sistema")
public interface StudySessionControllerDocs {

    @Operation(summary = "Cria uma nova sessão de Estudo",
            description = "Cria e retorna as informações da sessão de estudo criada.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sessão de Estudo criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados "),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Token inválido ou expirado "),
            @ApiResponse(responseCode = "404", description = "Usuário ou Aula associada não encontrada")
    })
    ResponseEntity<StudySessionResponseDTO> createStudySession(
            StudySessionRequestDTO request
            );


    @Operation(summary = "Busca uma sessão de estudo pelo ID",
            description = "Retorna as informações detalhadas de uma sessão de estudo específica.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sessão de Estudo encontrada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Token inválido ou expirado "),
            @ApiResponse(responseCode = "404", description = "Sessão de Estudo não encontrada")
    })
        ResponseEntity<StudySessionResponseDTO> findStudySessionById(
                Long id
    );

    @Operation(summary = "Lista todos as sessões de estudo",
            description = "Retorna uma lista paginada de todos as sessões de estudo cadastradas. Requer permissão de ADMIN.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista recuperada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado (Requer role ADMIN)")
    })
    ResponseEntity<Page<StudySessionResponseDTO>> findAllStudySessions(
            Pageable pageable
    );

    @Operation(summary = "Atualiza uma sessão de estudo",
            description = "Atualiza informações de uma sessão de estudo.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sessão de Estudo atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados"),
            @ApiResponse(responseCode = "403", description = "Acesso negado"),
            @ApiResponse(responseCode = "404", description = "Sessão de Estudo não encontrada")
    })
    ResponseEntity<StudySessionResponseDTO> updateStudySession(
            Long id,
            UpdateStudySessionRequestDTO requestDTO
    );

    @Operation(summary = "Exclui uma sessão de estudo",
            description = "Remove uma sessão de estudo do banco de dados pelo seu ID. Requer permissão de ADMIN.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Sessão de Estudo excluída com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Requer role ADMIN"),
            @ApiResponse(responseCode = "404", description = "Sessão de Estudo não encontrada")
    })
    ResponseEntity<Void> deleteStudySession(
            Long id
    );
}