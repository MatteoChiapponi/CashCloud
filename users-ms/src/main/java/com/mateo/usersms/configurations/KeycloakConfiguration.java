package com.mateo.usersms.configurations;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "keycloak")
public class KeycloakConfiguration {


    @Bean
    public RealmResource getRealm() {
        return getInstance().realm("CashCloud_realm");
    }

    @Bean
    public Keycloak getInstance() {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080")
                .realm("CashCloud_realm")
                .clientId("api-users-ms")
                .clientSecret("AQCgcVjKkkC38wDILaNnLYtIObFUFbMf")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();
    }

}
