package com.practica.api.entity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SeguridadYConfiguracion {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                // Permitir que cualquiera acceda al health check
                .requestMatchers("/actuator/health").permitAll()
                
                // Cualquier otro endpoint de actuator requiere autenticación
                .requestMatchers("/actuator/**").authenticated()
                
                // Las demás URLs son públicas
                .anyRequest().permitAll()
            )
            .httpBasic(httpBasic -> {}) // Usar autenticación básica
            .csrf(csrf -> csrf.disable()); // Desactivar CSRF para APIs

        return http.build();
    }

    @Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
            .username("usuario")
            .password(passwordEncoder().encode("password123"))  // Codifica la contraseña
            .roles("USER")
            .build();
        
        return new InMemoryUserDetailsManager(user);
    }
}
}