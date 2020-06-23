package com.seller.service;

import com.seller.beans.Product;
import com.seller.beans.SubCategory;
import com.seller.dao.CategoryDao;
import com.seller.dao.ProductDao;
import com.seller.dao.ProductPriceDao;
import com.seller.dao.SubCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.LinkedList;

@Component
public class Search {
    @Autowired
    SubCategoryDao subCategoryDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    ProductPriceDao productPriceDao;

    public LinkedList<SubCategory> getAllSubCategories(String category) throws SQLException {
        return categoryDao.getSubCategories(category);
    }


    public LinkedList<Product> getAllProducts(String subCategory) throws SQLException {
        return subCategoryDao.getProducts(subCategory);
    }
}
