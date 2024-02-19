package com.mateo.notificationsms.dtos;

public record NewUserInfo(
        String firstName,
        String lastName,
        String email,
        String phoneNumber
) {
}