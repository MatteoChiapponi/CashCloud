package com.cashcloud.keycloakmanagerms.bussiness.dtos.response;

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
