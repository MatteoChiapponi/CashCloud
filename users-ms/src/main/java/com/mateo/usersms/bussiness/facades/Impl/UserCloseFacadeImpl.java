package com.mateo.usersms.bussiness.facades.Impl;

import com.mateo.usersms.bussiness.facades.IUserCloseFacade;
import com.mateo.usersms.bussiness.services.keycloak.IKeycloakService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCloseFacadeImpl implements IUserCloseFacade {

    private final IKeycloakService keycloakService;
    @Override
    public void logoutUser(String userId) {
        SecurityContextHolder.clearContext();
        keycloakService.logoutUserFromKeycloak(userId);
    }

}
