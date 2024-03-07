package com.cashcloud.keycloakmanagerms.bussiness.services.keycloak;

import com.cashcloud.keycloakmanagerms.bussiness.dtos.UserAuthenticatedResponseDto;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.UserAuthenticationRequestDto;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.UserDataToRegisterInKeycloak;

public interface IKeycloakService {
    void logoutUserFromKeycloak(String userId);
    String registerNewUserOnKeycloak(UserDataToRegisterInKeycloak userData);
    UserAuthenticatedResponseDto authenticateUser(UserAuthenticationRequestDto userAuthenticationRequestDto);

}
