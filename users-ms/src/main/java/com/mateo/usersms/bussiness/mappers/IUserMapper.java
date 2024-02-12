package com.mateo.usersms.bussiness.mappers;

import com.mateo.usersms.persistence.entities.User;

public interface IUserMapper<T> {
    User toUser(T toBeMapped);
}
