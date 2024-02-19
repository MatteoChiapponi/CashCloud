package com.mateo.usersms.bussiness.services.keycloak;

import com.mateo.usersms.model.dtos.SaveUserDto;

public interface IKeycloakAuthService {

    void registerNewUserOnKeycloak(SaveUserDto saveUserDto);
}
