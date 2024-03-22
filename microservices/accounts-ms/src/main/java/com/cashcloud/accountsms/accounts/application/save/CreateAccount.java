package com.cashcloud.accountsms.accounts.application.save;

import com.cashcloud.accountsms.accounts.domain.Account;
import com.cashcloud.accountsms.accounts.domain.ports.SaveAccountRepository;
import com.cashcloud.accountsms.accounts.infrastructure.dtos.events.NewUserRegisteredData;
import com.cashcloud.accountsms.alias.domain.Alias;
import com.cashcloud.accountsms.alias.domain.ports.GenerateAlias;
import com.cashcloud.accountsms.cvu.domain.Cvu;
import com.cashcloud.accountsms.cvu.domain.ports.GenerateCvu;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAccount {

    private final SaveAccountRepository saveAccountRepository;
    private final GenerateAlias generateAliasService;
    private final GenerateCvu generateCvuService;

    public void createAndSaveAccount(NewUserRegisteredData message){

        var alias = new Alias(generateAliasService.generateAlias());
        var cvu = new Cvu(generateCvuService.generateCvu());

        var newUserAccount = new Account(message.userIdGeneratedByKeycloak(), alias,cvu);

        saveAccountRepository.saveAccount(newUserAccount);

    }
}
