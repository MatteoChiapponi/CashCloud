package com.cashcloud.keycloakmanagerms.bussiness.services.broker_pusblishers.impl;

import com.cashcloud.keycloakmanagerms.bussiness.dtos.events.NewUserRegisteredData;
import com.cashcloud.keycloakmanagerms.bussiness.services.broker_pusblishers.IBrokerPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewUserRegisteredOnKeycloak implements IBrokerPublisher<NewUserRegisteredData> {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(NewUserRegisteredData message) {
        rabbitTemplate.convertAndSend("users_exchange","new.user.registered.keycloak", message);
    }
}
