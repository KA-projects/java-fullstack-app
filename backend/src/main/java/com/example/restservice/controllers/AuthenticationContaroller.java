package com.example.restservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.restservice.model.AuthenticationResponse;
import com.example.restservice.model.RegisterRequest;
import com.example.restservice.services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationContaroller {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request) throws Exception {
        return ResponseEntity.ok(authenticationService.register(request));
    }
}
