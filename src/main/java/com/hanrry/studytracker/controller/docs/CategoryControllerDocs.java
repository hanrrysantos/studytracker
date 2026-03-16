package com.hanrry.studytracker.controller.docs;

import com.hanrry.studytracker.dto.CategoryRequestDTO;
import com.hanrry.studytracker.dto.CategoryResponseDTO;
import com.hanrry.studytracker.dto.UpdateCategoryRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Tag(name = "Categorias", description = "Endpoints para gerenciamento de categorias do sistema")
public interface CategoryControllerDocs {

    @Operation(summary = "Cria uma nova categoria",
            description = "Cria e retorna as informações da categoria criada.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados "),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Token inválido ou expirado "),
            @ApiResponse(responseCode = "404", description = "Usuário associado não encontrado")
    })
    ResponseEntity<CategoryResponseDTO> createCategory(
            CategoryRequestDTO request
            );


    @Operation(summary = "Busca uma categoria pelo ID",
            description = "Retorna as informações detalhadas de uma categoria específica.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria encontrada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Token inválido ou expirado "),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
        ResponseEntity<CategoryResponseDTO> findCategoryById(
                Long id
    );

    @Operation(summary = "Lista todos as categorias",
            description = "Retorna uma lista paginada de todos as categorias cadastrados. Requer permissão de ADMIN.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista recuperada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado (Requer role ADMIN)")
    })
    ResponseEntity<Page<CategoryResponseDTO>> listAllCategories(
            Pageable pageable
    );

    @Operation(summary = "Atualiza uma categoria",
            description = "Atualiza informações de uma categoria.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados"),
            @ApiResponse(responseCode = "403", description = "Acesso negado"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    ResponseEntity<CategoryResponseDTO> updateCategory(
            Long id,
            UpdateCategoryRequestDTO requestDTO
    );

    @Operation(summary = "Exclui uma categoria",
            description = "Remove uma categoria do banco de dados pelo seu ID. Requer permissão de ADMIN.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Categoria excluída com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Requer role ADMIN"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    ResponseEntity<Void> deleteCategoryById(
            Long id
    );
}