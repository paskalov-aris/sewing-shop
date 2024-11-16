package com.example.sewingshop;

import java.util.ArrayList;

public class Cart {
    private static ArrayList<ProductModel> cartItems = new ArrayList<>();

    public static void addToCart(ProductModel product) {
            cartItems.add(product);
    }

    public static ArrayList<ProductModel> getCartItems() {
        return cartItems;
    }

    public static boolean isProductInCart(String productName) {
        for (ProductModel cartItem : cartItems) {
            // Compare product IDs (assuming `getId()` returns a unique identifier)
            if (cartItem.getName().equals(productName)) {
                return true;  // Product is already in the cart
            }
        }
        return false;  // Product is not in the cart
    }
}
