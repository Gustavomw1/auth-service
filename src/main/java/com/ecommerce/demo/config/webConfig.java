package com.ecommerce.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig {

    @Bean // cria e configura um objeto que eu quero que seja um bean gerenciado
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override // é uma anotação que você coloca antes de um método para dizer que ele está
                      // sobrescrevendo
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5500", "http://127.0.0.1:5500")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");

            }
        };
    }
}
