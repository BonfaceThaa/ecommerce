package com.example.ecom.dto;

import javax.validation.constraints.NotNull;

public class ProductDTO {
    private @NotNull String name;;
    private @NotNull String description;

    public ProductDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
