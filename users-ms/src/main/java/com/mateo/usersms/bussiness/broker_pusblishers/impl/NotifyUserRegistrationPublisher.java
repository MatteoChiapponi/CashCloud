package com.mateo.usersms.bussiness.broker_pusblishers.impl;

import com.mateo.usersms.bussiness.broker_pusblishers.IBrokerPublisher;
import com.mateo.usersms.model.dtos.UserEmailDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotifyUserRegistrationPublisher implements IBrokerPublisher<UserEmailDataDto> {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(UserEmailDataDto message) {
        rabbitTemplate.convertAndSend("users_exchange","new.user.registered", message);
        System.out.println("mensaje publicado");
    }

}
