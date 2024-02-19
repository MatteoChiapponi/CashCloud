package com.mateo.usersms.bussiness.services.keycloak.impl;

import com.mateo.usersms.bussiness.services.keycloak.IKeycloakAuthService;
import com.mateo.usersms.model.dtos.SaveUserDto;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KeycloakAuthService implements IKeycloakAuthService {
    private final RealmResource realmResource;

    @Override
    public void registerNewUserOnKeycloak(SaveUserDto saveUserDto) {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setEnabled(true);
        userRepresentation.setUsername(saveUserDto.email());
        userRepresentation.setEmail(saveUserDto.email());
        userRepresentation.setFirstName(saveUserDto.firstName());
        userRepresentation.setLastName(saveUserDto.lastName());
        userRepresentation.setEmailVerified(true);

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setValue(saveUserDto.password());
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);


        var credentialRepresentationList = List.of(credentialRepresentation);
        userRepresentation.setCredentials(credentialRepresentationList);


        Response response = realmResource.users().create(userRepresentation);

    }
}
