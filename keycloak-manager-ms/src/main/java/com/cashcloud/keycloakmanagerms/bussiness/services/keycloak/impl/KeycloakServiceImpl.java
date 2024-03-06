package com.cashcloud.keycloakmanagerms.bussiness.services.keycloak.impl;

import com.cashcloud.keycloakmanagerms.bussiness.dtos.UserAuthenticatedResponseDto;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.UserAuthenticationRequestDto;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.UserDataToRegisterInKeycloak;
import com.cashcloud.keycloakmanagerms.bussiness.services.keycloak.IKeycloakService;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeycloakServiceImpl implements IKeycloakService {

    private final RealmResource realmResource;
    private String realm = "CashCloud_realm";
    private String clientSecret = "AQCgcVjKkkC38wDILaNnLYtIObFUFbMf";
    private String serverUrl = "http://localhost:8080/";
    private String clientId = "api-users-ms";


    private void sendVerificationEmail(String email){
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

    @Override
    public void registerNewUserOnKeycloak(UserDataToRegisterInKeycloak userData) {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setEnabled(true);
        userRepresentation.setUsername(userData.email());
        userRepresentation.setEmail(userData.email());
        userRepresentation.setFirstName(userData.firstName());
        userRepresentation.setLastName(userData.lastName());
        userRepresentation.setEmailVerified(false);

        userRepresentation.setGroups(List.of("new_users_group"));

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setValue(userData.password());
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);


        var credentialRepresentationList = List.of(credentialRepresentation);
        userRepresentation.setCredentials(credentialRepresentationList);


        Response response = realmResource.users().create(userRepresentation);

        // manejar exceptions
        System.out.println(response.getStatus());

        sendVerificationEmail(userData.email());

    }

    @Override
    public UserAuthenticatedResponseDto authenticateUser(UserAuthenticationRequestDto userAuthenticationRequestDto) {
        var keycloakUser = Keycloak.getInstance(serverUrl,realm,userAuthenticationRequestDto.email(), userAuthenticationRequestDto.password(), clientId, clientSecret);

        var userTokenManager = keycloakUser.tokenManager();

        // 400 contraseña incorrecta
        var response = new UserAuthenticatedResponseDto(
                userTokenManager.getAccessTokenString(),
                userTokenManager.refreshToken().getRefreshToken()
        );
        return response;
    }

}
