package com.mateo.usersms.model.dtos;

public record SaveUserDto (
         String firstName,
         String lastName,
         String identificationCard,
         String email,
         String phoneNumber,
         String password
){
}
