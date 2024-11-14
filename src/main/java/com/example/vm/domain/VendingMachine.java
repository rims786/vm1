package com.example.vm.domain;


import java.util.HashMap;
import java.util.Map;

/**
 * Represents the vending machine which holds products.
 */
public class VendingMachine {
    private final Map<String, Product> products;

    public VendingMachine() {
        products = new HashMap<>();
    }

    /**
     * Adds a product to the vending machine.
     *
     * @param product the product to add
     */
    public void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    /**
     * Retrieves a product by name.
     *
     * @param productName the name of the product
     * @return the product if found, null otherwise
     */
    public Product getProduct(String productName) {
        return products.get(productName);
    }

    /**
     * Displays the available products in the vending machine.
     */
    public void displayProducts() {
        System.out.println("Available Products:");
        for (Product product : products.values()) {
            System.out.printf("%s: SEK %.2f (Quantity: %d)%n", product.getName(), product.getPrice(), product.getQuantity());
        }
    }
}