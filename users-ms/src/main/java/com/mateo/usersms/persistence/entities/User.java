package com.mateo.usersms.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String identificationCard;
    private final String email;
    private final String phoneNumber;

}
