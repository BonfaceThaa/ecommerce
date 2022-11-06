package com.example.ecom.dto.order;

public class CheckoutItemDTO {
    private String productName;
    private int quantity;
    private double price;
    private Long productID;
    private int userId;

    public CheckoutItemDTO() {
    }

    public CheckoutItemDTO(String productName, int quantity, double price, Long productID, int userId) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.productID = productID;
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
