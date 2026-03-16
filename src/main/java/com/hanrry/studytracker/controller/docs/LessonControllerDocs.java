package com.hanrry.studytracker.controller.docs;

import com.hanrry.studytracker.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Tag(name = "Lição", description = "Endpoints para gerenciamento de lições do sistema")
public interface LessonControllerDocs {

    @Operation(summary = "Cria uma nova lição", description = "Cria e retorna as informações da lição criada.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Lição criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados "),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Token inválido ou expirado "),
            @ApiResponse(responseCode = "404", description = "Módulo associado não encontrado")
    })
    ResponseEntity<LessonResponseDTO> createLesson(
            LessonRequestDTO request
            );


    @Operation(summary = "Busca uma lição pelo ID",
            description = "Retorna as informações detalhadas de uma lição específica.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lição encontrada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Token inválido ou expirado "),
            @ApiResponse(responseCode = "404", description = "Lição não encontrada")
    })
        ResponseEntity<LessonResponseDTO> findLessonById(
                Long id
    );

    @Operation(summary = "Lista todos as lições",
            description = "Retorna uma lista paginada de todos as lições cadastradas. Requer permissão de ADMIN.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista recuperada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado (Requer role ADMIN)")
    })
    ResponseEntity<Page<LessonResponseDTO>> findAllLessons(
            Pageable pageable
    );

    @Operation(summary = "Atualiza uma lição",
            description = "Atualiza informações de uma lição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lição atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados"),
            @ApiResponse(responseCode = "403", description = "Acesso negado"),
            @ApiResponse(responseCode = "404", description = "Lição não encontrada")
    })
    ResponseEntity<LessonResponseDTO> updateLessons(
            Long id,
            UpdateLessonRequestDTO requestDTO
    );

    @Operation(summary = "Exclui uma lição",
            description = "Remove uma lição do banco de dados pelo seu ID. Requer permissão de ADMIN.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Lição excluída com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Requer role ADMIN"),
            @ApiResponse(responseCode = "404", description = "Lição não encontrada")
    })
    ResponseEntity<Void> deleteLessons(
            Long id
    );
}