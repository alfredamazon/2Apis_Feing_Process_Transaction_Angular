package com.plataformasespeciales.api_procesador.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http

            // Desactivar CSRF para pruebas con Angular/Postman
            .csrf(csrf -> csrf.disable())


            // Activar CORS
            .cors(cors -> 
                cors.configurationSource(corsConfigurationSource())
            )


            // Permitir consola H2
            .headers(headers ->
                headers.frameOptions(frame -> frame.sameOrigin())
            )


            .authorizeHttpRequests(auth -> auth


                // Permitir solicitudes OPTIONS de CORS
                .requestMatchers(HttpMethod.OPTIONS, "/**")
                .permitAll()


                // Consola H2
                .requestMatchers("/h2-console/**")
                .permitAll()


                // Login
                .requestMatchers(HttpMethod.POST, "/auth/login")
                .permitAll()


                // Procesamiento de transacciones
                .requestMatchers(HttpMethod.POST, "/transacciones")
                .permitAll()


                // Para la evaluación dejamos todo permitido
                .anyRequest()
                .permitAll()
            );


        return http.build();
    }




    @Bean
    public CorsConfigurationSource corsConfigurationSource() {


        CorsConfiguration configuration = new CorsConfiguration();


        // Angular
        configuration.setAllowedOrigins(
            List.of(
                "http://localhost:4200",
                "http://localhost:4300"
            )
        );


        configuration.setAllowedMethods(
            List.of(
                "GET",
                "POST",
                "PUT",
                "DELETE",
                "OPTIONS"
            )
        );


        configuration.setAllowedHeaders(
            List.of("*")
        );


        configuration.setAllowCredentials(true);



        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();


        source.registerCorsConfiguration(
            "/**",
            configuration
        );


        return source;
    }

}