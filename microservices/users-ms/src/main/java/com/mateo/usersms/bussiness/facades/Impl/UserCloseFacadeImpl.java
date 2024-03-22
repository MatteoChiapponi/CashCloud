package com.mateo.usersms.bussiness.facades.Impl;

import com.mateo.usersms.bussiness.facades.IUserCloseFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCloseFacadeImpl implements IUserCloseFacade {

    @Override
    public void logoutUser(String userId) {
        SecurityContextHolder.clearContext();
    }

}
