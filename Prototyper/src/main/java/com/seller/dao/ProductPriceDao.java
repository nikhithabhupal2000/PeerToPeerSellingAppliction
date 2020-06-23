package com.seller.dao;

import com.seller.beans.ProductPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Component
public class ProductPriceDao {
    @Autowired
    ConnectionManager connectionManager;
    Connection conn = null;
    ProductPriceDao() throws SQLException {
        //conn = connectionManager.getConnection();
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerapp", "nikhithabhupal2000", "abpns@2000");
    }

    public void addProductPrice(ProductPrice productPrice) throws SQLException {
        String query = "insert into productpricing value(?,?,?)";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, productPrice.getProductId());
        statement.setInt(2,productPrice.getUserId());
        statement.setInt(3,productPrice.getPrice());
        statement.executeUpdate();
    }


}
