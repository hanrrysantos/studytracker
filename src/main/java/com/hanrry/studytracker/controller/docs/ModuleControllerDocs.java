package com.hanrry.studytracker.controller.docs;

import com.hanrry.studytracker.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Tag(name = "Módulos", description = "Endpoints para gerenciamento de modulos do sistema")
public interface ModuleControllerDocs {

    @Operation(summary = "Cria um novo modulo",
            description = "Cria e retorna as informações do modulo criado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Modulo criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados "),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Token inválido ou expirado "),
            @ApiResponse(responseCode = "404", description = "Curso associado nao encontrado")
    })
    ResponseEntity<ModuleResponseDTO> createModule(
            ModuleRequestDTO request
            );

    @Operation(summary = "Busca um modulo pelo ID",
            description = "Retorna as informações detalhadas de um modulo específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modulo encontrado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Token inválido ou expirado "),
            @ApiResponse(responseCode = "404", description = "Modulo não encontrado")
    })
        ResponseEntity<ModuleResponseDTO> findModuleById(
                Long id
    );

    @Operation(summary = "Lista todos os modulos",
            description = "Retorna uma lista paginada de todos os modulos cadastrados. Requer permissão de ADMIN.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista recuperada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado (Requer role ADMIN)")
    })
    ResponseEntity<Page<ModuleResponseDTO>> findAllModules(
            Pageable pageable
    );

    @Operation(summary = "Atualiza um modulo",
            description = "Atualiza informações de um modulo.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modulo atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados"),
            @ApiResponse(responseCode = "403", description = "Acesso negado"),
            @ApiResponse(responseCode = "404", description = "Modulo não encontrado")
    })
    ResponseEntity<ModuleResponseDTO> updateModule(
            Long id,
            UpdateModuleRequestDTO requestDTO
    );

    @Operation(summary = "Exclui um modulo",
            description = "Remove um modulo do banco de dados pelo seu ID. Requer permissão de ADMIN.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Modulo excluído com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Requer role ADMIN"),
            @ApiResponse(responseCode = "404", description = "Modulo não encontrado")
    })
    ResponseEntity<Void> deleteModule(
            Long id
    );
}