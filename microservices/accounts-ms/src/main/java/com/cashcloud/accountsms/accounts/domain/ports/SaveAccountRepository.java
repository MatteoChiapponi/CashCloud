package com.cashcloud.accountsms.accounts.domain.ports;

import com.cashcloud.accountsms.accounts.domain.Account;

public interface SaveAccountRepository {

    void saveAccount(Account account);

}
