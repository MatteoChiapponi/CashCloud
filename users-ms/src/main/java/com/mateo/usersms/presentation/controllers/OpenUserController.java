package com.mateo.usersms.presentation.controllers;

import com.mateo.usersms.bussiness.facades.IUserFacade;
import com.mateo.usersms.model.dtos.SaveUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/open")
@RequiredArgsConstructor
public class OpenUserController{
    private final IUserFacade userFacade;

    public ResponseEntity<String> save(SaveUserDto saveUserDto){
        return ResponseEntity.ok(userFacade.saveUser(saveUserDto));
    }

}
