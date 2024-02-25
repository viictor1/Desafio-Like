package com.desafiolike.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {

        return new OpenAPI()
                .info(new Info()
                        .title("Desafio Técnico Like Sistemas")
                        .version("v1")
                        .termsOfService("Api Rest com spring boot 3.2.2")
                        .license(new License().name("Apache 2.0").url(""))
                );
    }
}
