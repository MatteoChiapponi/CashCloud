package com.cashcloud.accountsms.cvu;

import com.cashcloud.accountsms.cvu.domain.service.GenerateCvuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GenerateCvuServiceTest {
    @Autowired
    private GenerateCvuService cvuGeneratorService;

    @Test
    void testCvu (){
        System.out.println(cvuGeneratorService.generateCvu());
    }

}