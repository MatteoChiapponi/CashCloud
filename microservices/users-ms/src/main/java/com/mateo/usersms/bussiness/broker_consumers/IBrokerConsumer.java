package com.mateo.usersms.bussiness.broker_consumers;

public interface IBrokerConsumer<T>{
    void consume( T topicMessage);
}
