package com.cashcloud.accountsms.alias.domain.ports;

import com.cashcloud.accountsms.alias.domain.service.AliasGeneratorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GenerateAliasTest {

    @Autowired
    private AliasGeneratorService aliasGeneratorServiceImpl;
    private

    @Test
    void testAlias() {
        var alias = aliasGeneratorServiceImpl.generateAlias();
        System.out.println(alias);
    }


}