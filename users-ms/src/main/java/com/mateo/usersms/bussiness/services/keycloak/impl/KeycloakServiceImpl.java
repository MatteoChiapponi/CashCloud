package com.mateo.usersms.bussiness.services.keycloak.impl;

import com.mateo.usersms.bussiness.services.keycloak.IKeycloakService;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeycloakServiceImpl implements IKeycloakService {

    private final RealmResource realmResource;

    @Override
    public void sendVerificationEmail(String email){
        var users = realmResource.users().searchByEmail(email,true);
        users.stream().findFirst().ifPresentOrElse(
                user -> {
                    if (!user.isEmailVerified())
                        realmResource.users().get(user.getId()).sendVerifyEmail();
                },
                () -> {
                    throw new RuntimeException("user not found");
                }
        );
    }

    @Override
    public void logoutUserFromKeycloak(String userId) {
        realmResource.users().get(userId).logout();
    }

}
