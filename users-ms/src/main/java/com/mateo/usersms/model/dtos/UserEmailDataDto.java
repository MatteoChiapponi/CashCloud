package com.mateo.usersms.model.dtos;

import java.io.Serializable;

public record UserEmailDataDto(
        String firstName,
        String lastName,
        String email
) implements Serializable {
}