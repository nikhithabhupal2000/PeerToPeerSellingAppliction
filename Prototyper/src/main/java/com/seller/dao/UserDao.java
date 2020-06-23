package com.seller.dao;

import com.seller.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserDao {
    Connection conn ;
    @Autowired
    ConnectionManager connectionManager;

    public UserDao() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerapp", "nikhithabhupal2000", "abpns@2000");
        /*
        System.out.println("Entered");
        conn = connectionManager.getConnection();
        System.out.println("exit");

         */
    }

    public int addUser(User user) throws SQLException {
        String query = "insert into users(userName, pwd, phoneNumber) values(?,?,?)";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, user.getUserName());
        statement.setString(2,user.getPwd());
        statement.setString(3,user.getPhoneNumber());
        return statement.executeUpdate();
    }

    public User getUser(String userName) throws SQLException {
        User user = null;
        ResultSet rs = null;
        String query = "select * from users where userName = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1,userName);
        rs = statement.executeQuery();
        if(rs.next()){
            user = new User(
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
            );
        }
        return user;
    }

}
