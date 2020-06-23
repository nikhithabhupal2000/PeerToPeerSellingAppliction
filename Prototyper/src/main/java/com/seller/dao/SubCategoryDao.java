package com.seller.dao;

import com.seller.beans.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.LinkedList;

@Component
public class SubCategoryDao {
    Connection conn = null;
    @Autowired
    ConnectionManager connectionManager;
    ResultSet rs = null;
    SubCategoryDao() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerapp", "nikhithabhupal2000", "abpns@2000");
        //conn = connectionManager.getConnection();
    }

    public void addSubCategory(int subCategoryId, String subCategoryName, int categoryId) throws SQLException {
        String query = "insert into subCategories values(?,?, ?)";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1,subCategoryId);
        statement.setString(2,subCategoryName);
        statement.setInt(3,categoryId);
        statement.executeUpdate();
    }


    public LinkedList<Product> getProducts(String subCategory) throws SQLException {
        String query = "select product.productId, product.productName, product.productImage  from subcategories inner join product on subcategories.subCategoryId = product.subCategoryId where subcategories.subCategoryName = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, subCategory);
        rs = statement.executeQuery();
        LinkedList<Product> products = new LinkedList<>();
        while(rs.next()){
            Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3));
            products.add(p);
        }
        return  products;
    }

    public int getId(String subCategoryName) throws SQLException {
        String query = "select subCategoryId from subcategories where subCategoryName = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, subCategoryName);
        rs = statement.executeQuery();
        int subCategoryId = -1;
        if(rs.next()){
            subCategoryId = rs.getInt(1);
        }
        return subCategoryId;
    }

}
