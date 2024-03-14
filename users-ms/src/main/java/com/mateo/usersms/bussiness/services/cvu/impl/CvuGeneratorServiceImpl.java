package com.mateo.usersms.bussiness.services.cvu.impl;

import com.mateo.usersms.bussiness.services.cvu.ICvuGeneratorService;
import com.mateo.usersms.bussiness.services.users.IUserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class CvuGeneratorServiceImpl implements ICvuGeneratorService {

    private final IUserValidationService userValidationService;

    public static final String PSP = "11110000";

    public String generateCvu(){
        var currentCvu = PSP;
        for (int i = 0; i < 14; i++) {
            currentCvu+= ThreadLocalRandom.current().nextInt(0, 9);
        }
        if (userValidationService.isCvuAvailable(currentCvu)){
            return currentCvu;
        }
        generateCvu();
        return null;
    }

}
