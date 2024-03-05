package com.mateo.usersms.bussiness.facades.Impl;

import com.mateo.usersms.bussiness.broker_pusblishers.IBrokerPublisher;
import com.mateo.usersms.bussiness.facades.IUserOpenFacade;
import com.mateo.usersms.bussiness.mappers.IUserMapper;
import com.mateo.usersms.bussiness.services.keycloak.IKeycloakAuthService;
import com.mateo.usersms.bussiness.services.users.IUserService;
import com.mateo.usersms.bussiness.services.users.alias.IAliasGeneratorService;
import com.mateo.usersms.bussiness.services.users.cvu.ICvuGeneratorService;
import com.mateo.usersms.model.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserOpenFacadeImpl implements IUserOpenFacade {
    private final IUserService userService;
    private final IUserMapper<SaveUserDto> userMapper;
    private final IAliasGeneratorService aliasGeneratorService;
    private final ICvuGeneratorService cvuGeneratorService;
    private final IBrokerPublisher<UserEmailDataDto> brokerPublisher;
    private final IKeycloakAuthService keycloakAuthService;
    @Override
    public UserRegistrationResponseDto registerUser(SaveUserDto saveUserDto) {

        //save user on IAM (keycloak)
        keycloakAuthService.registerNewUserOnKeycloak(saveUserDto);

        var user = userMapper.toUser(saveUserDto);

        //generate and set alias
        var alias = aliasGeneratorService.generateAlias();
        user.setAlias(alias);

        //generate and set cvu
        var cvu = cvuGeneratorService.generateCvu();
        user.setCvu(cvu);


        //save user on db
        var userId = userService.saveUser(user);

        //publish event on rabbit with user data
        brokerPublisher.publish(new UserEmailDataDto(
                saveUserDto.firstName(),
                saveUserDto.lastName(),
                saveUserDto.email())
        );

        var response = new UserRegistrationResponseDto(
                userId,
                saveUserDto.firstName(),
                saveUserDto.lastName(),
                saveUserDto.identificationCard(),
                saveUserDto.email(),
                saveUserDto.phoneNumber(),
                cvu,alias
        );

        return response;
    }

    @Override
    public UserAuthenticatedResponseDto authenticateUser(UserAuthenticationRequestDto userAuthenticationRequestDto) {
        var exists = userService.existsByEmail(userAuthenticationRequestDto.email());
        if (!exists)
            throw new RuntimeException("user not found");

        var response = keycloakAuthService.authenticateUser(userAuthenticationRequestDto);
        return response;
    }


}
