package com.mateo.usersms.bussiness.broker_pusblishers;

public interface IBrokerPublisher <T>{
    void publish(T message);
}
