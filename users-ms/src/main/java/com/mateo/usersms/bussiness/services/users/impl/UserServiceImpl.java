package com.mateo.usersms.bussiness.services.users.impl;

import com.mateo.usersms.bussiness.services.users.IUserService;
import com.mateo.usersms.persistence.entities.User;
import com.mateo.usersms.persistence.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;


    public User loadUserByUsername(String email) {
        var userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent())
            return userOptional.get();
        throw new RuntimeException("user not found");
    }

    @Override
    public Long saveUser(User user) {
        var response = userRepository.save(user);
        return response.getId();
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }


}
