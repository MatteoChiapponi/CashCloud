package com.cashcloud.keycloakmanagerms.bussiness.dtos;

public record UserDataToRegisterInKeycloak(
        long id,
        String firstName,
        String lastName,
        String email,
        String password
) {
}
