package com.example.savannah_furnitures.controllers;

import com.example.savannah_furnitures.DTO.RegisterRequestDTO;
import com.example.savannah_furnitures.entities.User;
import com.example.savannah_furnitures.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequestDTO requestDTO) {
        User user = userService.registerUser(requestDTO);
        return ResponseEntity.ok(
                "User Registered: " + user.getUsername()
        );
    }

}
