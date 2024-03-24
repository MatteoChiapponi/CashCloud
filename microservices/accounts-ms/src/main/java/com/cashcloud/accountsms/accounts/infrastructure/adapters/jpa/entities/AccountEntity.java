package com.cashcloud.accountsms.accounts.infrastructure.adapters.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {

    @Id
    private String userId;
    private String alias;
    private String cvu;
    private Double totalAmount;
}
