package com.sdg4.microservicio_Cartilla.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;

@Configuration
@EnableR2dbcRepositories(
        basePackages = "com.sdg4.microservicio_Cartilla.Elections.repositories.reactive"
)
public class R2dbcConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactoryBuilder.withUrl("r2dbc:postgresql://localhost:5432/ms-cartilla")
                .username("root")
                .password("root")
                .build();
    }

    @Bean
    public DatabaseClient databaseClient(ConnectionFactory connectionFactory) {
        return DatabaseClient.builder()
                .connectionFactory(connectionFactory)
                .build();
    }
}

