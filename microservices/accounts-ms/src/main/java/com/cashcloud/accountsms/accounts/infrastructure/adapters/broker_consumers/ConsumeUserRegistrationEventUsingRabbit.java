package com.cashcloud.accountsms.accounts.infrastructure.adapters.broker_consumers;

import com.cashcloud.accountsms.accounts.application.save.CreateAccount;
import com.cashcloud.accountsms.accounts.domain.ports.ConsumeUserRegistrationEvent;
import com.cashcloud.accountsms.accounts.infrastructure.dtos.events.NewUserRegisteredData;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumeUserRegistrationEventUsingRabbit implements ConsumeUserRegistrationEvent {
    private final CreateAccount createAccount;
    Logger logger = LoggerFactory.getLogger(ConsumeUserRegistrationEventUsingRabbit.class);

    @Override
    @RabbitListener(queues = "generate-user-account")
    public void consumeUserRegistration(@Payload NewUserRegisteredData message) {
        logger.info("generando cuenta al nuevo usuario registrado: "+ message.email() + message.firstName() + message.lastName());
        createAccount.createAndSaveAccount(message);
    }



}
