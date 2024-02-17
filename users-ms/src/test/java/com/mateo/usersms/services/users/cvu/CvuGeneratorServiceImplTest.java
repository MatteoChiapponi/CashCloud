package com.mateo.usersms.services.users.cvu;

import com.mateo.usersms.bussiness.services.users.cvu.impl.CvuGeneratorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@RequiredArgsConstructor
class CvuGeneratorServiceImplTest {
    private final CvuGeneratorServiceImpl cvuGeneratorService;

    @Test
    void testCvu (){
        System.out.println(cvuGeneratorService.generateCvu());
    }

}