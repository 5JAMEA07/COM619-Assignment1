package com.group.devops.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("https://kryptonite.uksouth.cloudapp.azure.com"))
                .addServersItem(new Server().url("http://localhost:8080"))
                .info(new Info().title("Kryptonite Group API")
                        .description("This Application built by the Kryptonite group allows users to upload geographic points with descriptions of their current geolocation.")
                        .version("v1.0"));
    }
}

