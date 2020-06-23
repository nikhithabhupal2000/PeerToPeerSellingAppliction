package com.seller.dao;

import com.seller.beans.Product;
import com.seller.beans.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class ProductDao {
    CategoryDao categoryDao;
    SubCategoryDao subCategoryDao;
    Connection conn = null;
    @Autowired
    ConnectionManager connectionManager;

    ProductDao() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerapp", "nikhithabhupal2000", "abpns@2000");
        //conn = connectionManager.getConnection();
    }

    private boolean isCategoryPresent(int categoryId) throws SQLException {
        ResultSet rs = null;
        String query = "select * from categories where categoryId = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, categoryId);
        rs = statement.executeQuery();
        return rs.next();
    }

    private boolean isSubCategoryPresent(int subCategoryId) throws SQLException {
        ResultSet rs = null;
        String query = "select * from subCategories where categoryId = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, subCategoryId);
        rs = statement.executeQuery();
        return rs.next();
    }

    private void insertProduct(Product product) throws SQLException {
        String query = "insert into product(productName, productImage, subCategoryId) values(?,?,?)";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1,product.getProductName());
        statement.setString(2,product.getProductImage());
        statement.setInt(3, product.getSubCategoryId());
        statement.executeUpdate();
    }

    public void addProduct(Product product) throws SQLException {
        insertProduct(product);
/*
        int categoryId = product.getCategoryId();
        int subCategoryId = product.getSubCategoryId();
        if(isCategoryPresent(categoryId)){
            if(isSubCategoryPresent(subCategoryId)){
                insertProduct(product);
            }
            else{
                subCategoryDao.addSubCategory(product.getSubCategoryId(),product.getSubCategoryName(), product.getCategoryId());
                insertProduct(product);
            }
        }
        else{

            categoryDao.addCategory(product.getCategoryId(),product.getCategoryName());
            subCategoryDao.addSubCategory(product.getSubCategoryId(),product.getSubCategoryName(), product.getCategoryId());
            insertProduct(product);
        }*/

    }

}
