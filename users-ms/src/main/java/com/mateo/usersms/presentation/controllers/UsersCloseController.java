package com.mateo.usersms.presentation.controllers;

import com.mateo.usersms.bussiness.facades.IUserCloseFacade;
import com.mateo.usersms.model.dtos.SaveUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/close")
@RequiredArgsConstructor
public class UsersCloseController {

    private final IUserCloseFacade userCloseFacade;

    @PostMapping("/logout")
    public ResponseEntity userLogout(){
        var userId = SecurityContextHolder.getContext().getAuthentication().getName();
        userCloseFacade.logoutUser(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/test")
    public String test (){
        var h = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        System.out.println(h);
        var n = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(n);

        System.out.println(SecurityContextHolder.getContext().getAuthentication().getDetails());
        var f = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        System.out.println(f);
        var g = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(g);
        SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().forEach(aith -> System.out.println(aith.getAuthority()));
        return "test";
    }

}
