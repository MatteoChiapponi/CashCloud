package com.cashcloud.accountsms.accounts.infrastructure.broker_consumers;

public interface IBrokerConsumer<T>{
    void consume( T topicMessage);
}
