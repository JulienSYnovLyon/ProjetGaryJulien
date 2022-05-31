package com.project.springproject.api;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.web.bind.annotation.RequestMapping;

public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        License license = new License().name("Apache2.0").url("https://springdoc.org/");
        Info info = new Info().title("J2EE TD Spring REST API").version("v0.0.1").license(license);
        return new OpenAPI().info(info);
    }
    @Bean
    public GroupedOpenApi completeApi() {
        return
                GroupedOpenApi.builder().group("Complete").pathsToMatch("/**").build();
    }
}
