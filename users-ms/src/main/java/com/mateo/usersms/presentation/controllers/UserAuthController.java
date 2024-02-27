package com.mateo.usersms.presentation.controllers;

import com.mateo.usersms.bussiness.broker_pusblishers.IBrokerPublisher;
import com.mateo.usersms.bussiness.facades.IUserFacade;
import com.mateo.usersms.model.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/auth")
@RequiredArgsConstructor
public class UserAuthController {

    private final IUserFacade userFacade;
    private final IBrokerPublisher<UserEmailDataDto> stringIBrokerPublisher;

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponseDto> registerNewUser(@RequestBody SaveUserDto saveUserDto){
        var registeredUser = userFacade.registerUser(saveUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/login")
    public ResponseEntity<UserAuthenticatedResponseDto> authenticateUser(@RequestBody UserAuthenticationRequestDto userAuthenticationRequestDto) {
        stringIBrokerPublisher.publish(new UserEmailDataDto("mateo","chiapp","mateo@gmail.com"));
        var response = userFacade.authenticateUser(userAuthenticationRequestDto);
        return ResponseEntity.ok(response);
    }

}
