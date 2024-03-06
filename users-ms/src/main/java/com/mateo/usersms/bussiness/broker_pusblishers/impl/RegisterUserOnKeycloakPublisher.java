package com.mateo.usersms.bussiness.broker_pusblishers.impl;

import com.mateo.usersms.bussiness.broker_pusblishers.IBrokerPublisher;
import com.mateo.usersms.model.dtos.UserDataToRegisterInKeycloak;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserOnKeycloakPublisher implements IBrokerPublisher<UserDataToRegisterInKeycloak> {

    private final RabbitTemplate rabbitTemplate;
    @Override
    public void publish(UserDataToRegisterInKeycloak message) {
        rabbitTemplate.convertAndSend("users_exchange","register.user.keycloak", message);
        System.out.println("mensaje publicado");
    }
}
