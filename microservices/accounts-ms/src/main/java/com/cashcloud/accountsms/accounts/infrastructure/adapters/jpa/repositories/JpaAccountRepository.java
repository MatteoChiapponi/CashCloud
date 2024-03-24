package com.cashcloud.accountsms.accounts.infrastructure.adapters.jpa.repositories;

import com.cashcloud.accountsms.accounts.infrastructure.adapters.jpa.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAccountRepository extends JpaRepository<AccountEntity, String> {
    boolean existsByAlias(String alias);

    boolean existsByCvu(String cvu);
}
