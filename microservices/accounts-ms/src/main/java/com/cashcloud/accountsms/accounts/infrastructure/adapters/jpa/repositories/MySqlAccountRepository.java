package com.cashcloud.accountsms.accounts.infrastructure.adapters.jpa.repositories;

import com.cashcloud.accountsms.accounts.domain.Account;
import com.cashcloud.accountsms.accounts.domain.ports.repository.AccountRepository;
import com.cashcloud.accountsms.accounts.infrastructure.mappers.AccountEntityMapper;
import com.cashcloud.accountsms.alias.domain.ports.CheckIfAliasIsAvailable;
import com.cashcloud.accountsms.cvu.domain.ports.CheckIfCvuIsAvailable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MySqlAccountRepository implements AccountRepository, CheckIfAliasIsAvailable, CheckIfCvuIsAvailable {
    private final JpaAccountRepository jpaAccountRepository;
    private final AccountEntityMapper<Account> accountEntityMapper;
    @Override
    public void saveAccount(Account account) {
        //mappear de dominio a entidad de base de datos
        var accountEntityMapped = accountEntityMapper.toAccountEntity(account);

        jpaAccountRepository.save(accountEntityMapped);
    }

    @Override
    public boolean isAliasAvailable(String alias) {
        return !jpaAccountRepository.existsByAlias(alias);
    }

    @Override
    public boolean isCvuAvailable(String cvu) {
        return !jpaAccountRepository.existsByCvu(cvu);
    }
}
