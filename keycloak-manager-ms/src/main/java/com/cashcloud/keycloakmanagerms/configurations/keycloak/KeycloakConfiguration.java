package com.cashcloud.keycloakmanagerms.configurations.keycloak;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfiguration {
    private String realm = "CashCloud_realm";
    private String clientSecret = "AQCgcVjKkkC38wDILaNnLYtIObFUFbMf";
    private String serverUrl = "http://localhost:8080/";
    private String clientId = "keycloak-manager-service";

    @Bean
    public RealmResource getRealm() {
        return getInstance().realm(realm);
    }

    @Bean
    public Keycloak getInstance() {
        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();
    }

}
