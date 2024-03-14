package com.cashcloud.keycloakmanagerms.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/keycloak/open/")
public class KeycloakOpenController {
    @PostMapping("/login")

}
