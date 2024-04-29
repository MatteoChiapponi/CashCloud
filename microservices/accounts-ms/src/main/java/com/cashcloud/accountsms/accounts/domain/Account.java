package com.cashcloud.accountsms.accounts.domain;


import com.cashcloud.accountsms.alias.domain.Alias;
import com.cashcloud.accountsms.cvu.domain.Cvu;
import lombok.Getter;

@Getter
public class Account {

    private String userId;
    private Alias alias;
    private Cvu cvu;
    private Double totalAmount;
    //transacciones


    public Account(String userId, Alias alias, Cvu cvu) {
        this.userId = userId;
        this.alias = alias;
        this.cvu = cvu;
        this.totalAmount = 0.0;
    }
}
