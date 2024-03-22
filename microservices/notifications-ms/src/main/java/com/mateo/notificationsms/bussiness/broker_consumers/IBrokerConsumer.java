package com.mateo.notificationsms.bussiness.broker_consumers;

public interface IBrokerConsumer<T>{
    void consume( T topicMessage);
}
