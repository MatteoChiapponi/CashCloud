package com.mateo.usersms.bussiness.services;

import com.mateo.usersms.persistence.entities.User;

public interface IUserService {
    void saveUser(User user);
    boolean existsByEmail(String email);
}
