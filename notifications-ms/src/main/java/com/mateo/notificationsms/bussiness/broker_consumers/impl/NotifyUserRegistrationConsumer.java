package com.mateo.notificationsms.bussiness.broker_consumers.impl;

import com.mateo.notificationsms.bussiness.broker_consumers.IBrokerConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotifyUserRegistrationConsumer implements IBrokerConsumer<String> {

    Logger logger = LoggerFactory.getLogger(NotifyUserRegistrationConsumer.class);

    @Override
    @RabbitListener(queues = "new-registered-users")
    public void consume(String message) {
        logger.info("nuevo usuario registrado: "+ message);
    }



}
