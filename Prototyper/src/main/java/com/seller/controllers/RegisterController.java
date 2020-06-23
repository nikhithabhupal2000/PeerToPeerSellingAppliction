package com.seller.controllers;

import com.seller.beans.User;
import com.seller.dao.ConnectionManager;
import com.seller.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
@Controller
public class RegisterController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/Registration")
    String registerUser(HttpServletRequest request) throws SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phoneNumber");
        User user = new User(username,password,phone);
        userDao.addUser(user);
        return "FirstPage";
    }
}
