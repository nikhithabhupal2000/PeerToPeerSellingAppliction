package com.seller.controllers;

import com.seller.dao.ConnectionManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class HomeController {

    @GetMapping("/")
    String showHomePage(){
        return "mainPage";
    }

    @RequestMapping("/LoginPage")
    String showLoginPage(){
        return "login";
    }

    @RequestMapping("/RegisterPage")
    String showRegisterPage(){
        return "register";
    }


}
