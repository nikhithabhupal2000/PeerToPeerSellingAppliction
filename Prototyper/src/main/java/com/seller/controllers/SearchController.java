package com.seller.controllers;

import com.seller.beans.Product;
import com.seller.beans.SubCategory;
import com.seller.service.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.LinkedList;

@Controller
public class SearchController {

    @Autowired
    Search search;

    @RequestMapping("/subCategories")
    String getSubCategories(HttpServletRequest request) throws SQLException {
        String category = request.getParameter("Category");
        LinkedList<SubCategory> subCategories = search.getAllSubCategories(category);
        request.setAttribute("SubCategories", subCategories);
        return "SubCategoriesPage";
    }

    @RequestMapping("/products")
    String getProducts(HttpServletRequest request) throws SQLException {
        String subCategory = request.getParameter("subCategory");
        LinkedList<Product> products = search.getAllProducts(subCategory);
        request.setAttribute("Products", products);
        return "ProductsPage";
    }



}
