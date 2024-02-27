package com.mateo.usersms.bussiness.facades;

import com.mateo.usersms.model.dtos.SaveUserDto;
import com.mateo.usersms.model.dtos.UserAuthenticatedResponseDto;
import com.mateo.usersms.model.dtos.UserAuthenticationRequestDto;
import com.mateo.usersms.model.dtos.UserRegistrationResponseDto;

public interface IUserFacade {
    UserRegistrationResponseDto registerUser(SaveUserDto saveUserDto);
    UserAuthenticatedResponseDto authenticateUser(UserAuthenticationRequestDto userAuthenticationRequestDto);
}
