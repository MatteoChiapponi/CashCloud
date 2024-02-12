package com.mateo.usersms.bussiness.mappers.impl;

import com.mateo.usersms.bussiness.mappers.IUserMapper;

import com.mateo.usersms.model.dtos.SaveUserDto;
import com.mateo.usersms.persistence.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements IUserMapper<SaveUserDto> {

    @Override
    public User toUser(SaveUserDto saveUserDto) {
        return new User(saveUserDto.firstName(),
                saveUserDto.lastName(),
                saveUserDto.identificationCard(),
                saveUserDto.email(),
                saveUserDto.phoneNumber(),
                saveUserDto.password());
    }


}
