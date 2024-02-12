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


    public User loadUserByUsername(String username) {
        var userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent())
            return userOptional.get();
        throw new RuntimeException("user not found");
    }

    @Override
    public void saveUser(User user) {

    }
}
