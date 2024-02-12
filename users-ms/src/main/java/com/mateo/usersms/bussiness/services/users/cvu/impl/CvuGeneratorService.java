package com.mateo.usersms.bussiness.services.users.cvu.impl;

import java.util.concurrent.ThreadLocalRandom;

public class CvuGeneratorService {

    private String cvu;
    public static final String PSP = "11110000";

    public CvuGeneratorService() {
        this.cvu = generateCvu();
    }

    public String getCvu() {
        return cvu;
    }
    private String generateCvu(){

        var currentCvu = PSP;
        for (int i = 0; i < 14; i++) {
            currentCvu+= ThreadLocalRandom.current().nextInt(0, 9);
        }
        return currentCvu;
    }

}
