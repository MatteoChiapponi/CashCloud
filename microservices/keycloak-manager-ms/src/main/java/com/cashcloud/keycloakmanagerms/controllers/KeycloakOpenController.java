package com.cashcloud.keycloakmanagerms.controllers;

import com.cashcloud.keycloakmanagerms.bussiness.dtos.requests.RegisterUserRequestDto;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.response.UserAuthenticatedResponseDto;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.requests.UserAuthenticationRequestDto;
import com.cashcloud.keycloakmanagerms.bussiness.facades.IOpenEndpointsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/keycloak/open/")
public class KeycloakOpenController {

    private final IOpenEndpointsFacade openEndpointsFacade;

    @PostMapping("/register")
    public ResponseEntity userRegistration(@RequestBody RegisterUserRequestDto registerUserRequestDto){
        openEndpointsFacade.registerUser(registerUserRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthenticatedResponseDto> userLogin(@RequestBody UserAuthenticationRequestDto userAuthenticationRequestDto) {
        var response = openEndpointsFacade.authenticateUser(userAuthenticationRequestDto);
        return ResponseEntity.ok(response);
    }

}
