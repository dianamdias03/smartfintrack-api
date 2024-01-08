package com.api.smartfintrackapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, CorsConfigurationSource corsConfigurationSource) throws Exception {
        http
            .cors().configurationSource(corsConfigurationSource)
                .and()
            .csrf().disable()
            .authorizeRequests()
                .requestMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
            // Outras configurações de segurança
            ;

        return http.build();
    }
}