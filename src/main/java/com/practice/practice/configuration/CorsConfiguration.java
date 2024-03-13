package com.practice.practice.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración de CORS para peticiones.
 * Permite realizar peticiones de cualquier origen
 */
@Configuration
public class CorsConfiguration {
    /**
     * Configura los CORS para permitir peticiones desde
     * cualquier orígen y permite los metodos HTTP GET, POST,
     * PUT y DELETE para las peticiones
     * @return Un objeto WebMvcConfigurer que configura CORS
     */
    @Bean
    public WebMvcConfigurer CORSConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT","DELETE");
            }
        };
    }
}