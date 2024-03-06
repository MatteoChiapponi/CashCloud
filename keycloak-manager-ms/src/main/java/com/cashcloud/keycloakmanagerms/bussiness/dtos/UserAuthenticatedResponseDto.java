package com.cashcloud.keycloakmanagerms.bussiness.dtos;

public record UserAuthenticatedResponseDto(
        String accessToken,
        String refreshToken
) {
}
