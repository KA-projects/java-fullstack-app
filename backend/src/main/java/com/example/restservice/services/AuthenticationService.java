package com.example.restservice.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.restservice.model.AuthenticationResponse;
import com.example.restservice.model.RegisterRequest;
import com.example.restservice.model.User;
import com.example.restservice.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) throws Exception {
        var user = User.builder().firstname(request.getFirstname()).lastname(request.getLastname())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone()).city(request.getCity()).build();

        if (userRepository.findByEmail(request.getEmail()).equals(request.getEmail())) {
            throw new Exception("We have user with the same email");
        }

        userRepository.save(user);
        var token = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(token).build();
    }

}
