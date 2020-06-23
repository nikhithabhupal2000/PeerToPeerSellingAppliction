package com.seller.dao;

import com.seller.beans.Category;
import com.seller.beans.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.LinkedList;

@Component
public class CategoryDao {
    Connection conn = null;
    @Autowired
    ConnectionManager connectionManager;
    ResultSet rs = null;
    CategoryDao() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerapp", "nikhithabhupal2000", "abpns@2000");
        //conn = connectionManager.getConnection();
    }

    public void addCategory(int categoryId, String categoryName) throws SQLException {
        String query = "insert into categories values(?,?)";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1,categoryId);
        statement.setString(2,categoryName);
        statement.executeUpdate();
    }

    public LinkedList<SubCategory> getSubCategories(String c) throws SQLException {
        LinkedList<SubCategory> subCategories = new LinkedList<>();
        String query = "select subcategories.subCategoryId, subcategories.subCategoryName from categories inner join subcategories on categories.categoryId = subcategories.categoryId where categories.categoryName = ? ";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1,c);
        rs = statement.executeQuery();
        while(rs.next()){
            int subCategoryId = rs.getInt(1);
            String subCategoryName = rs.getString(2);
            SubCategory s = new SubCategory(subCategoryId, subCategoryName);
            subCategories.add(s);
        }
        return  subCategories;
    }

    public int getId(String categoryName) throws SQLException {
        String query = "select categoryId from categories where categoryName = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, categoryName);
        rs = statement.executeQuery();
        int categoryId = -1;
        if(rs.next()){
            categoryId = rs.getInt(1);
        }
        return categoryId;
    }

}
