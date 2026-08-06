package com.example.savannah_furnitures.config;

import com.example.savannah_furnitures.entities.User;
import com.example.savannah_furnitures.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {

    @Bean
    @Profile("dev") // only runs when the "dev" profile is active
    public CommandLineRunner seedAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setEmail("admin@savannah.com");
                admin.setPassword(passwordEncoder.encode("changeMe123!"));
                admin.setRole("ADMIN");
                userRepository.save(admin);
            }
        };
    }
}