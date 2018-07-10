package com.example.demo.controller;

import com.example.demo.repository.AppRoleRepository;
import com.example.demo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    @Autowired
    private AppUserRepository users;

    @Autowired
    private AppRoleRepository roles;



    @RequestMapping ("/")
    public String showHome () {
        return "index";
    }

    @RequestMapping("/adduser")
    public String addUser (){
        return "adduser";
    }
}
