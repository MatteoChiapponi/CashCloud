package com.cashcloud.accountsms.accounts.domain.ports;

import com.cashcloud.accountsms.accounts.domain.Account;
import com.cashcloud.accountsms.accounts.domain.ports.repository.AccountRepository;
import com.cashcloud.accountsms.alias.domain.Alias;
import com.cashcloud.accountsms.cvu.domain.Cvu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;


    // hacer assert una vez se haga el puerto para buscar account por id
    @Test
    public void saveAccountTest(){

        var mockAlias = new Alias("alias de prueba");
        var mockCvu = new Cvu("cvu de pruena");

        var accountToSave = new Account("1",mockAlias,mockCvu);

        accountRepository.saveAccount(accountToSave);

    }

}