package com.pilkhwal.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI InventoryServiceAPI() {
        return new OpenAPI().info(new Info().title("Inventory Service API")
                .description("This is a rest api for Inventory service ")
                .version("v0.0.1")
                .license(new License().name("Pilkhwal 2.0"))
        ).externalDocs(new ExternalDocumentation()
                .description("Inventory service external description")
                .url("https://inventory-service-dummy-url.com/docs")
        );
    }
}
