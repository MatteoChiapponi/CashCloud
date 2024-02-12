package com.mateo.usersms.presentation.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/auth/")
@RequiredArgsConstructor
public class UserAuthController {

    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(){
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(){
        return null;
    }

}
