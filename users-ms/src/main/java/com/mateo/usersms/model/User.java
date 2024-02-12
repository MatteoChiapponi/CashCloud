package com.mateo.usersms.model;


public class User {
    private String firstName;
    private String lastName;
    private String identificationCard;
    private String email;
    private String phoneNumber;
    private String password;

    private String alias;
    private String cvu;
    public User(String firstName, String lastName, String identificationCard, String email, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationCard = identificationCard;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setCvu(String cvu) {
        this.cvu = cvu;
    }
}
