package com.cashcloud.keycloakmanagerms.bussiness.services.broker_consumers;

public interface IBrokerConsumer<T>{
    void consume( T topicMessage);
}
