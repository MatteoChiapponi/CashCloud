package com.cashcloud.accountsms.alias.domain.service;

import com.cashcloud.accountsms.alias.domain.ports.CheckIfAliasIsAvailable;
import com.cashcloud.accountsms.alias.domain.ports.GenerateAlias;
import com.cashcloud.accountsms.alias.domain.utils.IRandomWordGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AliasGeneratorService implements GenerateAlias {
    private final IRandomWordGenerator randomWordGenerator;
    private final CheckIfAliasIsAvailable checkIfAliasIsAvailable;

    // hacer inversion de dependencia y testear el metodo
    @Override
    public String generateAlias() {
        var currentAlias = "";
        for (int i = 0; i < 3; i++) {
            currentAlias+= randomWordGenerator.generateRandomWord() + ".";
        }
        var finalAliasString = currentAlias.substring(0,currentAlias.length()-1);
        if (checkIfAliasIsAvailable.isAliasAvailable(currentAlias)){
            return currentAlias;
        }
        return generateAlias();
    }
}
