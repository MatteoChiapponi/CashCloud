package com.cashcloud.accountsms.accounts.infrastructure.dtos.events;

public record NewUserRegisteredData(
        String userIdGeneratedByKeycloak,
        String firstName,
        String lastName,
        String email,
        String identificationCard,
        String phoneNumber

) {
}
