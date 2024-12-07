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
    public OpenAPI OrderServiceAPI() {
        return new OpenAPI().info(new Info().title("Order Service API")
                .description("This is a rest api for Order service ")
                .version("v0.0.1")
                .license(new License().name("Pilkhwal 2.0"))
        ).externalDocs(new ExternalDocumentation()
                .description("Order service external description")
                .url("https://product-service-dummy-url.com/docs")
        );
    }
}
