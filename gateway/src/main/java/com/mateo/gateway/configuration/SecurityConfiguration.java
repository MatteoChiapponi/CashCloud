package com.mateo.gateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) throws Exception {
        http.authorizeExchange(
                authorizeExchangeSpec ->
                                authorizeExchangeSpec.pathMatchers("/api/users/open/**").permitAll()
                                        .pathMatchers("/actuator/**").permitAll()
                                        .anyExchange().authenticated()

                        )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwkSetUri("http://localhost:8080/realms/CashCloud_realm/protocol/openid-connect/certs")
                        )
                );
        return http.build();
    }
}
