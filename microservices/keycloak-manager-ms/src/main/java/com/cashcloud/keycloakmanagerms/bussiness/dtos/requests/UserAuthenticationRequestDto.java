package com.cashcloud.keycloakmanagerms.bussiness.dtos.requests;

public record UserAuthenticationRequestDto(
        String email,
        String password
) {
}
