package com.seller.beans;

public class Product extends SubCategory{

    private int productId;
    private String productName;
    private String productImage;

    public Product(int categoryId, String categoryName, int subCategoryId, String subCategoryName,  String productName, String productImage) {
        super(categoryId,categoryName,subCategoryId,subCategoryName);
        this.productName = productName;
        this.productImage = productImage;
    }

    public Product(int productId, String productName, String productImage) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
