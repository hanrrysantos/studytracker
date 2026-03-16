package com.hanrry.studytracker.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                    .title("StudyTracker API")
                    .version("v1")
                    .description("API RESTful para a plataforma StudyTracker. " +
                            "Fornece recursos para o gerenciamento de usuários, cursos, categorias, módulos, aulas" +
                            " e acompanhamento detalhado de progresso e sessões de estudo.")
                    .termsOfService("https://github.com/hanrrysantos")
                    .license(new License())
                    .contact(new Contact()
                            .name("Hanrry")
                            .url("https://github.com/hanrrysantos")
                    )
            )
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
            .components(new Components()
                    .addSecuritySchemes("bearerAuth", new SecurityScheme()
                            .name("bearerAuth")
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")
                            .description("Insira o token JWT gerado no endpoint de login (/api/v1/auth/login)")
                    )
            );
    }

    @Bean
    public OpenApiCustomizer sortTagsCustomizer () {
        return openApi -> {
            List<String> ordemDesejada = List.of(
                    "Autenticação",
                    "Dashboard",
                    "Usuários",
                    "Categorias",
                    "Cursos",
                    "Módulos",
                    "Lição",
                    "Progresso das Aulas",
                    "Sessão de Estudo"
            );

            if (openApi.getTags() != null) {
                openApi.getTags().sort((t1, t2) -> {
                    int index1 = ordemDesejada.indexOf(t1.getName());
                    int index2 = ordemDesejada.indexOf(t2.getName());

                    if (index1 == -1) index1 = 999;
                    if (index2 == -1) index2 = 999;

                    return Integer.compare(index1, index2);
                });
            }
        };
    }
}
