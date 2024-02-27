package com.mateo.usersms.bussiness.services.keycloak;

import com.mateo.usersms.model.dtos.SaveUserDto;
import com.mateo.usersms.model.dtos.UserAuthenticatedResponseDto;
import com.mateo.usersms.model.dtos.UserAuthenticationRequestDto;

public interface IKeycloakAuthService {

    void registerNewUserOnKeycloak(SaveUserDto saveUserDto);

    UserAuthenticatedResponseDto authenticateUser(UserAuthenticationRequestDto userAuthenticationRequestDto);
}
