package com.mateo.usersms.bussiness.facades.Impl;

import com.mateo.usersms.bussiness.facades.IUserFacade;
import com.mateo.usersms.bussiness.mappers.IUserMapper;
import com.mateo.usersms.bussiness.services.users.IUserService;
import com.mateo.usersms.bussiness.services.users.alias.IAliasGeneratorService;
import com.mateo.usersms.bussiness.services.users.cvu.ICvuGeneratorService;
import com.mateo.usersms.model.dtos.SaveUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacadeImpl implements IUserFacade {
    private final IUserService userService;
    private final IUserMapper<SaveUserDto> userMapper;
    private final IAliasGeneratorService aliasGeneratorService;
    private final ICvuGeneratorService cvuGeneratorService;

    @Override
    public String registerUser(SaveUserDto saveUserDto) {
        var user = userMapper.toUser(saveUserDto);
        //generate alias
        var alias = aliasGeneratorService.generateAlias();
        //generate cvu
        var cvu = cvuGeneratorService.generateCvu();
        //generate and set user's roles

        user.setAlias(alias);
        user.setCvu(cvu);

        //

        //save user on db
        userService.saveUser(user);
        //save user on IAM (keycloak)

        return null;
    }
}
