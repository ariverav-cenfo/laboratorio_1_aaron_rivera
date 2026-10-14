package com.example.laboratorio_1_aaron_rivera.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginResponseDTO (
    @JsonProperty("access_token") String accessToken,
    @JsonProperty("refresh_token") String refreshToken,
    @JsonProperty("token_type") String tokenType,
    @JsonProperty("expires_in") long expiresIn
){}
