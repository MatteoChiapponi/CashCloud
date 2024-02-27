package com.mateo.usersms.bussiness.services.users.impl;

import com.mateo.usersms.bussiness.services.users.IUserValidationService;
import com.mateo.usersms.persistence.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserValidationServiceImpl implements IUserValidationService {
    private final IUserRepository userRepository;

    @Override
    public boolean isAliasAvailable(String alias) {
        return !userRepository.existsByAlias(alias);
    }

    @Override
    public boolean isCvuAvailable(String cvu) {
        return !userRepository.existsByCvu(cvu);
    }

    @Override
    public boolean isEmailAvailable(String email) {
        return !userRepository.existsByEmail(email);
    }

}
