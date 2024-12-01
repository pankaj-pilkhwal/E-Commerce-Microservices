package com.pilkhwal.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.*;

@Configuration
public class Routes {
    @Bean
    public RouterFunction<ServerResponse> productServiceRoute() {
        return GatewayRouterFunctions
                .route("product_service")
                .route(
                        RequestPredicates.GET("/api/product"),
                        HandlerFunctions.http("http://localhost:8080")
                )
                .route(
                        RequestPredicates.POST("/api/product"),
                        HandlerFunctions.http("http://localhost:8080")
                )
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceRoute() {
        return GatewayRouterFunctions
                .route("order_service")
                .route(
                        RequestPredicates.path("/api/order"),
                        HandlerFunctions.http("http://localhost:8081")
                )
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceRoute() {
        return GatewayRouterFunctions
                .route("inventory_service")
                .route(
                        RequestPredicates.path("/api/inventory"),
                        HandlerFunctions.http("http://localhost:8082")
                )
                .build();
    }

}
