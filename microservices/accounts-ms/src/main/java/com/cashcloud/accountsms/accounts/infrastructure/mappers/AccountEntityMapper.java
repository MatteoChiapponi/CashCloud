package com.cashcloud.accountsms.accounts.infrastructure.mappers;

import com.cashcloud.accountsms.accounts.infrastructure.adapters.jpa.entities.AccountEntity;

public interface AccountEntityMapper <ToBeMapped> {
        AccountEntity toAccountEntity(ToBeMapped toBeMapped);
}
