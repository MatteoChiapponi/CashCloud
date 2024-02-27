package com.mateo.usersms.configurations.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public Queue newUserRegisteredQueue(){
        return new Queue("new-registered-user");
    }
}
