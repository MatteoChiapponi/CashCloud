package com.cashcloud.keycloakmanagerms.bussiness.dtos.response;

public record UserAuthenticatedResponseDto(
        String accessToken,
        String refreshToken
) {
}
