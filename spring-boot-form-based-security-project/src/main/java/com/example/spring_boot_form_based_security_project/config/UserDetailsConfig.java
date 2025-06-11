package com.example.spring_boot_form_based_security_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // Marks this class as a Spring configuration
public class UserDetailsConfig {

    @Bean // Defines the user details service
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(); // In-memory user store

        // Create a user: username = admin, password = admin123 (BCrypt encrypted), role = ADMIN
        manager.createUser(
            User.withUsername("admin")
                .password(encoder.encode("admin123")) // Encrypt the password
                .roles("ADMIN") // Assign role
                .build()
        );

        return manager; // Return the in-memory user manager
    }
}
