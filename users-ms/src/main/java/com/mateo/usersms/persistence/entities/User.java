package com.mateo.usersms.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private UserRole userRole;
    private String identificationCard;
    private String email;
    private String phoneNumber;
    private String password;
    private String cvu;
    private String alias;

    public User(String firstName, String lastName, String identificationCard, String email, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationCard = identificationCard;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public void setCvu(String cvu) {
        this.cvu = cvu;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
