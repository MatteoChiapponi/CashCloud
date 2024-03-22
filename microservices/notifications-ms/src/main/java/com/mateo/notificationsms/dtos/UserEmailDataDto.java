package com.mateo.notificationsms.dtos;

import java.io.Serializable;

public record UserEmailDataDto(
        String firstName,
        String lastName,
        String email
) implements Serializable {
}