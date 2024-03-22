package com.mateo.usersms.bussiness.broker_consumers.impl;

import com.mateo.usersms.bussiness.broker_consumers.IBrokerConsumer;
import com.mateo.usersms.bussiness.mappers.IUserMapper;
import com.mateo.usersms.bussiness.services.IUserService;
import com.mateo.usersms.dtos.events.NewUserRegisteredData;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewUserRegisteredOnKeycloakConsumer implements IBrokerConsumer<NewUserRegisteredData> {

    Logger logger = LoggerFactory.getLogger(NewUserRegisteredOnKeycloakConsumer.class);

    private final IUserService userService;
    private final IUserMapper<NewUserRegisteredData> userMapper;

    @Override
    @RabbitListener(queues = "register-user")
    public void consume(@Payload NewUserRegisteredData message) {
        logger.info("nuevo usuario para registrar en ms de usuarios: "+ message.email() + message.firstName() + message.lastName());
        var ourUser= userMapper.toUser(message);
        userService.saveUser(ourUser);
    }



}
