package com.cashcloud.keycloakmanagerms.bussiness.facades;

import com.cashcloud.keycloakmanagerms.bussiness.dtos.requests.RegisterUserRequestDto;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.response.UserAuthenticatedResponseDto;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.requests.UserAuthenticationRequestDto;

public interface IOpenEndpointsFacade {


    void registerUser(RegisterUserRequestDto registerUserRequestDto);

    UserAuthenticatedResponseDto authenticateUser(UserAuthenticationRequestDto userAuthenticationRequestDto);
}
