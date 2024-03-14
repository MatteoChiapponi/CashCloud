package com.cashcloud.keycloakmanagerms.bussiness.facades.impl;

import com.cashcloud.keycloakmanagerms.bussiness.services.broker_pusblishers.IBrokerPublisher;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.events.NewUserRegisteredData;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.requests.RegisterUserRequestDto;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.requests.UserAuthenticationRequestDto;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.response.UserAuthenticatedResponseDto;
import com.cashcloud.keycloakmanagerms.bussiness.facades.IOpenEndpointsFacade;
import com.cashcloud.keycloakmanagerms.bussiness.services.keycloak.IKeycloakService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OpenEndpointsFacadeImpl implements IOpenEndpointsFacade {

    private final IBrokerPublisher<NewUserRegisteredData> newUserRegisteredBrokerPublisher;
    private final IKeycloakService keycloakService;
    @Override
    public void registerUser(RegisterUserRequestDto registerUserRequestDto) {

        var userIdGeneratedByKeycloak = keycloakService.registerNewUserOnKeycloak(registerUserRequestDto);

        //publish event on rabbit with user data
        newUserRegisteredBrokerPublisher.publish(new NewUserRegisteredData(
                userIdGeneratedByKeycloak,
                registerUserRequestDto.firstName(),
                registerUserRequestDto.lastName(),
                registerUserRequestDto.email(),
                registerUserRequestDto.identificationCard(),
                registerUserRequestDto.phoneNumber()
        ));

    }

    @Override
    public UserAuthenticatedResponseDto authenticateUser(UserAuthenticationRequestDto userAuthenticationRequestDto) {
        return keycloakService.authenticateUser(userAuthenticationRequestDto);
    }
}
