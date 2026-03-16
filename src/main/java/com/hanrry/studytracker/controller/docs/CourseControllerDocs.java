package com.hanrry.studytracker.controller.docs;

import com.hanrry.studytracker.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Tag(name = "Cursos", description = "Endpoints para gerenciamento de cursos do sistema")
public interface CourseControllerDocs {

    @Operation(summary = "Cria um novo curso",
            description = "Cria e retorna as informações do curso criado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Curso criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados "),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Token inválido ou expirado "),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })
    ResponseEntity<CourseResponseDTO> createCourse(
            CourseRequestDTO request
            );


    @Operation(summary = "Busca um curso pelo ID",
            description = "Retorna as informações detalhadas de um curso específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso encontrado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Token inválido ou expirado "),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })
        ResponseEntity<CourseResponseDTO> findCourseById(
                Long id
    );

    @Operation(summary = "Lista todos os cursos",
            description = "Retorna uma lista paginada de todos os cursos cadastrados. Requer permissão de ADMIN.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista recuperada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado (Requer role ADMIN)")
    })
    ResponseEntity<Page<CourseResponseDTO>> findAllCourses(
            Pageable pageable
    );

    @Operation(summary = "Atualiza um curso",
            description = "Atualiza informações de um curso.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados"),
            @ApiResponse(responseCode = "403", description = "Acesso negado"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })
    ResponseEntity<CourseResponseDTO> updateCourse(
            Long id,
            UpdateCourseRequestDTO requestDTO
    );

    @Operation(summary = "Exclui um curso",
            description = "Remove um curso do banco de dados pelo seu ID. Requer permissão de ADMIN.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Curso excluído com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Requer role ADMIN"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })
    ResponseEntity<Void> deleteCourse(
            Long id
    );
}