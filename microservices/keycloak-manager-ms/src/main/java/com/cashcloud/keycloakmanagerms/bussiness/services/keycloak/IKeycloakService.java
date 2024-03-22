package com.cashcloud.keycloakmanagerms.bussiness.services.keycloak;

import com.cashcloud.keycloakmanagerms.bussiness.dtos.requests.RegisterUserRequestDto;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.response.UserAuthenticatedResponseDto;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.requests.UserAuthenticationRequestDto;

public interface IKeycloakService {
    void logoutUserFromKeycloak(String userId);
    String registerNewUserOnKeycloak(RegisterUserRequestDto userData);
    UserAuthenticatedResponseDto authenticateUser(UserAuthenticationRequestDto userAuthenticationRequestDto);

}
