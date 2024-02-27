package com.mateo.usersms.model.dtos;

public record UserRegistrationResponseDto(
        Long id,
        String firstName,
        String lastName,
        String identificationCard,
        String email,
        String phoneNumber,
        String cvu,
        String alias
) {
}
