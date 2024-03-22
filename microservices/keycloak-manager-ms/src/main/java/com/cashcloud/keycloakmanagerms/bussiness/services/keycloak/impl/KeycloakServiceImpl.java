package com.cashcloud.keycloakmanagerms.bussiness.services.keycloak.impl;

import com.cashcloud.keycloakmanagerms.bussiness.dtos.requests.RegisterUserRequestDto;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.response.UserAuthenticatedResponseDto;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.requests.UserAuthenticationRequestDto;
import com.cashcloud.keycloakmanagerms.bussiness.services.keycloak.IKeycloakService;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class KeycloakServiceImpl implements IKeycloakService {

    private final RealmResource realmResource;
    private String realm = "CashCloud_realm";
    private String clientSecret = "AQCgcVjKkkC38wDILaNnLYtIObFUFbMf";
    private String serverUrl = "http://localhost:8080/";
    private String clientId = "api-users-ms";


    private String sendVerificationEmail(String email){
        var users = realmResource.users().searchByEmail(email,true);
        AtomicReference<String> idGeneratedByKeycloak = new AtomicReference<>();
        users.stream().findFirst().ifPresentOrElse(
                user -> {
                    if (!user.isEmailVerified()){
                        idGeneratedByKeycloak.set(user.getId());
                        realmResource.users().get(user.getId()).sendVerifyEmail();
                    }

                },
                () -> {
                    throw new RuntimeException("user not found");
                }
        );
        return idGeneratedByKeycloak.get();
    }

    @Override
    public void logoutUserFromKeycloak(String userId) {
        realmResource.users().get(userId).logout();
    }

    @Override
    public String registerNewUserOnKeycloak(RegisterUserRequestDto userData) {
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

        return sendVerificationEmail(userData.email());
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
