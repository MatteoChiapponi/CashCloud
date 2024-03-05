package com.mateo.usersms.bussiness.services.keycloak;

public interface IKeycloakService {
    void sendVerificationEmail(String keycloakUserId);
    void logoutUserFromKeycloak(String userId);
}
