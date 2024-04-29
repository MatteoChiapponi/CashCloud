package com.cashcloud.accountsms.accounts.domain.ports.repository;

import com.cashcloud.accountsms.accounts.domain.Account;

public interface AccountRepository {

    void saveAccount(Account account);


}
