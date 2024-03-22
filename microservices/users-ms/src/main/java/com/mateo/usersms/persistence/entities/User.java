package com.mateo.usersms.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private  String id;
    private  String firstName;
    private  String lastName;
    private  String identificationCard;
    private  String email;
    private  String phoneNumber;

}
