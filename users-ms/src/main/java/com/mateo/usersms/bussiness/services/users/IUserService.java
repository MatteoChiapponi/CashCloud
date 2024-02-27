package com.mateo.usersms.bussiness.services.users;

import com.mateo.usersms.persistence.entities.User;

public interface IUserService {
    Long saveUser(User user);
}
