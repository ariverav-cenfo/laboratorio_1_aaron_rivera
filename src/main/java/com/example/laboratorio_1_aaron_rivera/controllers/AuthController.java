package com.example.laboratorio_1_aaron_rivera.controllers;

import com.example.laboratorio_1_aaron_rivera.dto.LoginRequestDTO;
import com.example.laboratorio_1_aaron_rivera.dto.LoginResponseDTO;
import com.example.laboratorio_1_aaron_rivera.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request){
        return authService.login(request);
    }

}
