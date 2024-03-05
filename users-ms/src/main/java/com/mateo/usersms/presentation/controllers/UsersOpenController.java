package com.mateo.usersms.presentation.controllers;

import com.mateo.usersms.bussiness.facades.IUserOpenFacade;
import com.mateo.usersms.model.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/open")
@RequiredArgsConstructor
public class UsersOpenController {

    private final IUserOpenFacade userFacade;

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponseDto> userRegistration(@RequestBody SaveUserDto saveUserDto){
        var registeredUser = userFacade.registerUser(saveUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthenticatedResponseDto> userLogin(@RequestBody UserAuthenticationRequestDto userAuthenticationRequestDto) {
        var response = userFacade.authenticateUser(userAuthenticationRequestDto);
        return ResponseEntity.ok(response);
    }

}
