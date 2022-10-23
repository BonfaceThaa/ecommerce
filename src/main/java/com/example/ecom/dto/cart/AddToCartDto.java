package com.example.ecom.dto.cart;

import javax.validation.constraints.NotNull;

public class AddToCartDto {
    private Integer id;
    private @NotNull Integer productId;
    private @NotNull int quantity;

    public AddToCartDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
