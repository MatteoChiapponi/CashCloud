package com.cashcloud.keycloakmanagerms.bussiness.dtos.requests;

public record RegisterUserRequestDto(
         String firstName,
         String lastName,
         String identificationCard,
         String email,
         String phoneNumber,
         String password
)  {
}
