package com.mateo.usersms.bussiness.broker_pusblishers.impl;

import com.mateo.usersms.bussiness.broker_pusblishers.IBrokerPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationPublisher implements IBrokerPublisher<String> {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(String message) {
        rabbitTemplate.convertAndSend("new-registered-users", message);
    }
}
