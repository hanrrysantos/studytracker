package com.hanrry.studytracker.controller.docs;

import com.hanrry.studytracker.dto.LessonProgressRequestDTO;
import com.hanrry.studytracker.dto.LessonProgressResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Progresso das Aulas", description = "Endpoints para o gerenciamento e acompanhamento do progresso das aulas pelo usuário")
public interface LessonProgressControllerDocs {

    @Operation(summary = "Marca uma aula como concluída",
            description = "Registra o progresso do usuário, marcando uma aula específica como concluída.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aula marcada como concluída com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Token inválido ou expirado"),
            @ApiResponse(responseCode = "404", description = "Usuário ou Aula não encontrados")
    })
    ResponseEntity<LessonProgressResponseDTO> completeLesson(LessonProgressRequestDTO request);

    @Operation(summary = "Desmarca uma aula como concluída",
            description = "Remove o status de conclusão de uma aula, permitindo que o usuário a marque como pendente novamente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Status de conclusão removido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados enviados"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Token inválido ou expirado"),
            @ApiResponse(responseCode = "404", description = "Registro de progresso não encontrado")
    })
    ResponseEntity<LessonProgressResponseDTO> unCompleteLesson(LessonProgressRequestDTO request);

    @Operation(summary = "Busca o progresso de uma aula",
            description = "Retorna as informações de progresso de um usuário para uma aula específica.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Progresso recuperado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - Token inválido ou expirado"),
            @ApiResponse(responseCode = "404", description = "Registro de progresso não encontrado")
    })
    ResponseEntity<LessonProgressResponseDTO> findProgress(Long userId, Long lessonId);
}