package com.cashcloud.accountsms.accounts.domain.ports;

import com.cashcloud.accountsms.accounts.infrastructure.dtos.events.NewUserRegisteredData;

public interface ConsumeUserRegistrationEvent {
    void consumeUserRegistration(NewUserRegisteredData eventData);
}
