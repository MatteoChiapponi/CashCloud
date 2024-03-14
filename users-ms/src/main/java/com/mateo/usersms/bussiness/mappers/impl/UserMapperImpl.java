package com.mateo.usersms.bussiness.mappers.impl;

import com.mateo.usersms.bussiness.mappers.IUserMapper;

import com.mateo.usersms.dtos.events.NewUserRegisteredData;
import com.mateo.usersms.persistence.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements IUserMapper<NewUserRegisteredData> {

    @Override
    public User toUser(NewUserRegisteredData newUserRegisteredData) {
        return new User(
                newUserRegisteredData.userIdGeneratedByKeycloak(),
                newUserRegisteredData.firstName(),
                newUserRegisteredData.lastName(),
                newUserRegisteredData.identificationCard(),
                newUserRegisteredData.email(),
                newUserRegisteredData.phoneNumber()
        );
    }


}
