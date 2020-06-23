package com.seller.beans;

public class ProductPrice {

    private int productId;
    private int userId;
    private int price;

    public ProductPrice(int productId, int userId, int price) {
        this.productId = productId;
        this.userId = userId;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
