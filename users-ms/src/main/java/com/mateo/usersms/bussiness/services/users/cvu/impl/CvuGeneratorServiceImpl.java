package com.mateo.usersms.bussiness.services.users.cvu.impl;

import com.mateo.usersms.bussiness.services.users.cvu.ICvuGeneratorService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class CvuGeneratorServiceImpl implements ICvuGeneratorService {

    public static final String PSP = "11110000";

    public String generateCvu(){

        var currentCvu = PSP;
        for (int i = 0; i < 14; i++) {
            currentCvu+= ThreadLocalRandom.current().nextInt(0, 9);
        }
        return currentCvu;
    }

}
