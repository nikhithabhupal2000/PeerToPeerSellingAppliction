package com.seller.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@PropertySource("classpath:database-details.properties")
@Component
public class ConnectionManager {


    public static ConnectionManager instance = null;

    @Value("${musername}")
    private  String musername  ;
    @Value("${mpassword}")
    private String mpassword ;
   @Value("${murl}")
    private String murl ;

    private Connection conn = null;
    public Connection getConnection() throws SQLException {
        conn = DriverManager.getConnection(murl, musername, mpassword);
        return conn;
    }
    public void close() throws SQLException {
        if(conn != null) {
            conn.close();
        }
    }

}