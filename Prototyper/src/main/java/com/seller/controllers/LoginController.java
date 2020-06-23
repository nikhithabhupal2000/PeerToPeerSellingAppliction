package com.seller.controllers;

import com.seller.dao.ConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Controller("loginController")
public class LoginController {

    @Autowired
    ConnectionManager connectionManager;
   public String getPassword(String userName) throws ClassNotFoundException, SQLException {


        Connection conn = connectionManager.getConnection();

        if(conn == null){
            System.out.println("Connection is null");
        }
        System.out.println("Connection is established");
        String sql = "select pwd from users where userName = ?";
        ResultSet rs = null;
        try(
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, userName);
            rs = stmt.executeQuery();
            if(rs.next()) {
                return rs.getString(1);
            }
            return "no";

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;

    }

     boolean isValidUser(String username, String password) throws SQLException, ClassNotFoundException {
         System.out.println("In isValid User");
        String pwd = getPassword(username);
        return password.equals(pwd);
    }

    @RequestMapping(value = "/LoginPage", method = RequestMethod.POST)
    String validateAndLand(HttpServletRequest req, Model model) throws SQLException, ClassNotFoundException {
        System.out.println("In landing page");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(this.isValidUser(username, password)){
            return "FirstPage";
        }
        else{
            return "login";
        }

    }

}
