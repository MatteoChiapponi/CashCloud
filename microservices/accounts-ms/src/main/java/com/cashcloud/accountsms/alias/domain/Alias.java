package com.cashcloud.accountsms.alias.domain;

import lombok.Getter;

@Getter
public class Alias {

    private String alias;

    public Alias(String alias) {
        this.alias = alias;
    }
}
