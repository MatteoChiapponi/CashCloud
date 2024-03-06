package com.cashcloud.keycloakmanagerms.bussiness.services.broker_consumers.impl;

import com.cashcloud.keycloakmanagerms.bussiness.services.broker_consumers.IBrokerConsumer;
import com.cashcloud.keycloakmanagerms.bussiness.dtos.UserDataToRegisterInKeycloak;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class registerUserOnKeycloakConsumer implements IBrokerConsumer<UserDataToRegisterInKeycloak> {

    Logger logger = LoggerFactory.getLogger(registerUserOnKeycloakConsumer.class);

    @Override
    @RabbitListener(queues = "register_user_on_keycloak")
    public void consume(@Payload UserDataToRegisterInKeycloak message) {
        logger.info("nuevo usuario para registrar: "+ message.email() + message.firstName() + message.lastName());
    }



}
