package com.example.sewingshop;

public class ProductModel {
    String name;
    Integer code;
    String description;
    String price;
    int image;

    public ProductModel(String name, Integer code, String description, String price, int image) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }


    public String getPrice() {
        return price;
    }

    public int getImage() { return image; }
}
