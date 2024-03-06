package com.mateo.usersms.model.dtos;

public record UserAuthenticationRequestDto(
        String email,
        String password
) {
}
