package com.example.spring_boot_form_based_security_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // Marks this class as a configuration class for Spring
public class SecurityConfig {

    @Bean // Defines a security filter chain bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // Set authorization rules
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login").permitAll() // Publicly accessible URLs
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated() // All other URLs require authentication
            )
            // Enable form login
            .formLogin(form -> form
                .loginPage("/login") // Custom login page URL
                .defaultSuccessUrl("/dashboard", true) // Redirect here after successful login
                .permitAll() // Allow everyone to access login page
            )
            // Enable logout functionality
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout") // Redirect after logout
                .permitAll() // Allow everyone to access logout
            );

        return http.build(); // Return the configured security filter chain
    }

    @Bean // Password encoder bean using BCrypt
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Securely encodes passwords
    }
}