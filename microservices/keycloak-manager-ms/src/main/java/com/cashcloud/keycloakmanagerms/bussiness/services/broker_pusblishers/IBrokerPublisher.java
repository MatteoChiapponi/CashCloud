package com.cashcloud.keycloakmanagerms.bussiness.services.broker_pusblishers;

public interface IBrokerPublisher <T>{
    void publish(T message);
}
