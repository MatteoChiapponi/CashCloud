package com.cashcloud.accountsms.accounts.infrastructure.mappers.Impl;

import com.cashcloud.accountsms.accounts.domain.Account;
import com.cashcloud.accountsms.accounts.infrastructure.adapters.jpa.entities.AccountEntity;
import com.cashcloud.accountsms.accounts.infrastructure.mappers.AccountEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class DomainAccountToEntityAccount implements AccountEntityMapper<Account> {

    @Override
    public AccountEntity toAccountEntity(Account account) {

        return new AccountEntity(account.getUserId(),account.getAlias().getAlias(),account.getCvu().getCvu(), account.getTotalAmount());

    }
}
