package com.hanrry.studytracker.controller.docs;

import com.hanrry.studytracker.dto.DashboardResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Dashboard", description = "Endpoints para visualização de métricas e progresso geral do utilizador")
public interface DashboardControllerDocs {

    @Operation(summary = "Busca os dados do dashboard do utilizador",
            description = "Retorna um resumo contendo o total de sessões, horas estudadas, " +
                    "aulas concluídas e pendentes de um utilizador específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dashboard recuperado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Token inválido ou expirado"),
            @ApiResponse(responseCode = "404", description = "Utilizador não encontrado")
    })
    ResponseEntity<DashboardResponseDTO> findDashboard(Long id);
}