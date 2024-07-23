package com.sdg4.apiGateway.config;

import jakarta.annotation.PostConstruct;
import jdk.jfr.Enabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class GatewayConfig {
    @Autowired
    private RouteDefinitionLocator routeDefinitionLocator;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("cartilla-service-eleccion", r -> r.path("/eleccion/**")
                        .uri("lb://cartilla-service"))
                .route("cartilla-service-ballot", r -> r.path("/ballot/**")
                        .uri("lb://cartilla-service"))
                .route("cartilla-service-candidate", r -> r.path("/candidato/**")
                        .uri("lb://cartilla-service"))
                .route("vote-service", r -> r.path("/votes/**")
                        .uri("lb://vote-service"))
                .build();
    }

    @PostConstruct
    public void init() {
        routeDefinitionLocator.getRouteDefinitions().subscribe(route -> {
            System.out.println("Route ID: " + route.getId());
            System.out.println("Route URI: " + route.getUri());
            System.out.println("Route Predicates: " + route.getPredicates());
            System.out.println("Route Filters: " + route.getFilters());
        });
    }
}
