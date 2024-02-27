package com.mateo.usersms.services.users.alias;

import com.mateo.usersms.bussiness.services.users.alias.Impl.AliasGeneratorServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AliasGeneratorServiceImplTest {

    @Autowired
    private AliasGeneratorServiceImpl aliasGeneratorServiceImpl;

    @Test
    void testAlias() {
        System.out.println(aliasGeneratorServiceImpl.generateAlias());
    }
}