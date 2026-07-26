package com.kd.account.security.dto;

public record AuthenticationResponse(
        String accessToken,
        String tokenType
) {
}
