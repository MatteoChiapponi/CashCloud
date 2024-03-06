package com.mateo.usersms.model.dtos;

public record UserAuthenticatedResponseDto(
        String accessToken,
        String refreshToken
) {
}
