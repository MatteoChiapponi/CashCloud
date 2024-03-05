package com.mateo.usersms.bussiness.services.keycloak.impl;

import com.mateo.usersms.bussiness.services.keycloak.IKeycloakAuthService;
import com.mateo.usersms.bussiness.services.keycloak.IKeycloakService;
import com.mateo.usersms.model.dtos.SaveUserDto;
import com.mateo.usersms.model.dtos.UserAuthenticatedResponseDto;
import com.mateo.usersms.model.dtos.UserAuthenticationRequestDto;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KeycloakAuthServiceImpl implements IKeycloakAuthService {
    private final IKeycloakService keycloakService;
    private final RealmResource realmResource;
    @Override
    public void registerNewUserOnKeycloak(SaveUserDto saveUserDto) {

        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setEnabled(true);
        userRepresentation.setUsername(saveUserDto.email());
        userRepresentation.setEmail(saveUserDto.email());
        userRepresentation.setFirstName(saveUserDto.firstName());
        userRepresentation.setLastName(saveUserDto.lastName());
        userRepresentation.setEmailVerified(false);

        userRepresentation.setGroups(List.of("new_users_group"));

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setValue(saveUserDto.password());
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);


        var credentialRepresentationList = List.of(credentialRepresentation);
        userRepresentation.setCredentials(credentialRepresentationList);


        Response response = realmResource.users().create(userRepresentation);

        // manejar exceptions
        System.out.println(response.getStatus());

        keycloakService.sendVerificationEmail(saveUserDto.email());

    }

    @Override
    public UserAuthenticatedResponseDto authenticateUser(UserAuthenticationRequestDto userAuthenticationRequestDto) {

        var keycloakUser = Keycloak.getInstance("http://localhost:8080","CashCloud_realm",userAuthenticationRequestDto.email(), userAuthenticationRequestDto.password(), "api-users-ms", "AQCgcVjKkkC38wDILaNnLYtIObFUFbMf");

        var userTokenManager = keycloakUser.tokenManager();

        // 400 contraseña incorrecta
        var response = new UserAuthenticatedResponseDto(
                userTokenManager.getAccessTokenString(),
                userTokenManager.refreshToken().getRefreshToken()
        );
        return response;
    }

}


