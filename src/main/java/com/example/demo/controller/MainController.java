package com.example.demo.controller;

import com.example.demo.models.AppRole;
import com.example.demo.models.AppUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/")
public class MainController {

    @PostConstruct
    public void loadData(){
        AppUser user = new AppUser("user", "password");
        AppRole role = new AppRole("TEACHER");
        user.addRole(role);
    }
}
