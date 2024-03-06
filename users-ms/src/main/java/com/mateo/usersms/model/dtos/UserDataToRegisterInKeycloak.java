package com.mateo.usersms.model.dtos;

public record UserDataToRegisterInKeycloak(
        long id,
        String firstName,
        String lastName,
        String email,
        String password
) {
}
