package com.seller.controllers;

import com.seller.beans.Product;
import com.seller.beans.SubCategory;
import com.seller.dao.CategoryDao;
import com.seller.dao.ProductDao;
import com.seller.dao.ProductPriceDao;
import com.seller.dao.SubCategoryDao;
import com.seller.service.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class AddController {
    @Autowired
    Search search;
    @Autowired
    ProductDao productDao;
    @Autowired
    ProductPriceDao productPriceDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    SubCategoryDao subCategoryDao;

    @RequestMapping("/addProduct")
    String addProduct(HttpServletRequest request) throws SQLException {
        return "ProductDescriptionPage";
    }

    @RequestMapping("/confirmationPage")
    String addProductToDb(HttpServletRequest request) throws SQLException {
        String productName = request.getParameter("productName");
        String categoryName = request.getParameter("category");
        String subCategoryName = request.getParameter("subCategory");
        int price = Integer.parseInt(request.getParameter("price"));
        String productImage = request.getParameter("image");
        int categoryId = categoryDao.getId(categoryName);
        int subCategoryId = subCategoryDao.getId(subCategoryName);
        Product product = new Product(categoryId,categoryName,subCategoryId,subCategoryName,productName,productImage);
        productDao.addProduct(product);
        return "confirmedPage";
    }

}