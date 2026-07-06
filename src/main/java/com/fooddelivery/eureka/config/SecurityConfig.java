package com.fooddelivery.eureka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF — Eureka clients send heartbeats via POST/PUT
                // and don't carry CSRF tokens
                .csrf(csrf -> csrf.disable())
                // Allow actuator health endpoints without auth (for Docker healthchecks)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/actuator/health/**").permitAll()
                        .anyRequest().authenticated()
                )
                // HTTP Basic for Eureka dashboard and client registration
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
