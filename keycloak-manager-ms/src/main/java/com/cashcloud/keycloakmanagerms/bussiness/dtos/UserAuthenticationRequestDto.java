package com.cashcloud.keycloakmanagerms.bussiness.dtos;

public record UserAuthenticationRequestDto(
        String email,
        String password
) {
}
