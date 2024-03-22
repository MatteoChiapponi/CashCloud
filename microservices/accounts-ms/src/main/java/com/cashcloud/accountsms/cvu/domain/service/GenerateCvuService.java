package com.cashcloud.accountsms.cvu.domain.service;

import com.cashcloud.accountsms.cvu.domain.ports.CheckIfCvuIsAvailable;
import com.cashcloud.accountsms.cvu.domain.ports.GenerateCvu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class GenerateCvuService implements GenerateCvu {

    private final CheckIfCvuIsAvailable checkIfCvuIsAvailable;

    public static final String PSP = "11110000";

    @Override
    public String generateCvu(){
        var currentCvu = PSP;
        for (int i = 0; i < 14; i++) {
            currentCvu+= ThreadLocalRandom.current().nextInt(0, 9);
        }
        if (checkIfCvuIsAvailable.isCvuAvailable(currentCvu)){
            return currentCvu;
        }
        return generateCvu();
    }

}
