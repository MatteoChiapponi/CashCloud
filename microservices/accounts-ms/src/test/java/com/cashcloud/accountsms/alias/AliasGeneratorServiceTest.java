package com.cashcloud.accountsms.alias;

import com.cashcloud.accountsms.alias.domain.service.AliasGeneratorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AliasGeneratorServiceTest {

    @Autowired
    private AliasGeneratorService aliasGeneratorServiceImpl;

    @Test
    void testAlias() {
        System.out.println(aliasGeneratorServiceImpl.generateAlias());
    }
}