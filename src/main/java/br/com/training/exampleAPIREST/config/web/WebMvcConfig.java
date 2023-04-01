package br.com.training.exampleAPIREST.config.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${web.cors.origin}")
    private String origin;

    @Override
    public void addCorsMappings(CorsRegistry registry) { //Configuracao para cors e aceitar requisições do front
        registry.addMapping("/**")
                .allowedOrigins(origin)
                .allowedMethods("HEAD", "OPTIONS", "PUT", "POST", "GET", "DELETE", "PATCH")
                .maxAge(3600L);
        WebMvcConfigurer.super.addCorsMappings(registry);
    }
}
