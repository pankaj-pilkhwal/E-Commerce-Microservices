package com.pilkhwal.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    @Bean
    public RestClient restClient() {
        String baseUrl = "http://localhost:8082/api/inventory";
        return RestClient.builder().baseUrl(baseUrl).build();
    }
}
