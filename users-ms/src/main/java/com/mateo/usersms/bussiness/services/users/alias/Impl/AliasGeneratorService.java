package com.mateo.usersms.bussiness.services.users.alias.Impl;

import com.mateo.usersms.bussiness.services.users.IUserValidationService;
import com.mateo.usersms.bussiness.services.users.alias.IAliasGeneratorService;
import com.mateo.usersms.utils.IRandomWordGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AliasGeneratorService implements IAliasGeneratorService {
    private String alias;
    private final IRandomWordGenerator randomWordGenerator;
    private final IUserValidationService userValidationService;

    public String getAlias() {
        if (alias == null)
            generateAliass();
        return alias;
    }
    private void generateAliass(){
        var currentAlias = "";
        for (int i = 0; i < 3; i++) {
            currentAlias+= randomWordGenerator.generateRandomWord() + ".";
        }
        var finalAlias = currentAlias.substring(0,currentAlias.length()-1);
        alias = finalAlias;
        /*if (userValidationService.isAliasAvailable(finalAlias)){
            alias = finalAlias;
            return;
        }
        generateAlias();
         */
    }

    // hacer inversion de dependencia y testear el metodo
    @Override
    public String generateAlias() {
        var currentAlias = "";
        for (int i = 0; i < 3; i++) {
            currentAlias+= randomWordGenerator.generateRandomWord() + ".";
        }
        var finalAlias = currentAlias.substring(0,currentAlias.length()-1);
        if (userValidationService.isAliasAvailable(finalAlias)){
            return finalAlias;
        }
        generateAlias();
        return null;
    }
}
