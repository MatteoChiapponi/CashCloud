package com.mateo.usersms.services.users.cvu;

import com.mateo.usersms.bussiness.services.cvu.impl.CvuGeneratorServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CvuGeneratorServiceImplTest {
    @Autowired
    private CvuGeneratorServiceImpl cvuGeneratorService;

    @Test
    void testCvu (){
        System.out.println(cvuGeneratorService.generateCvu());
    }

}