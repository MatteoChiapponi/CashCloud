package com.mateo.notificationsms.bussiness.broker_consumers.impl;

import com.mateo.notificationsms.bussiness.broker_consumers.IBrokerConsumer;
import com.mateo.notificationsms.bussiness.services.IMailSenderService;
import com.mateo.notificationsms.bussiness.services.INotifyService;
import com.mateo.notificationsms.dtos.UserEmailDataDto;
import com.mateo.notificationsms.dtos.events.NewUserRegisteredData;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotifyUserRegistrationConsumer implements IBrokerConsumer<NewUserRegisteredData> {
    private final INotifyService<NewUserRegisteredData> notifyService;
    Logger logger = LoggerFactory.getLogger(NotifyUserRegistrationConsumer.class);

    @Override
    @RabbitListener(queues = "new_user_registered")
    public void consume(@Payload NewUserRegisteredData message) {
        logger.info("notificando nuevo usuario registrado: "+ message.email() + message.firstName() + message.lastName());
        notifyService.notify(message);
    }



}
