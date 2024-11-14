package com.example.vm.domain;
import java.util.logging.Logger;

/**
 * Represents a product in the vending machine.
 */
public class Product {
    private String name;
    private double price;
    private int quantity;
    private static final Logger logger = Logger.getLogger(Product.class.getName());

    /**
     * Constructs a Product with the specified name, price, and quantity.
     *
     * @param name     the name of the product
     * @param price    the price of the product
     * @param quantity the quantity of the product
     */
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * Checks if the product is available for purchase.
     *
     * @return true if the product is available, false otherwise
     */
    public boolean isAvailable() {
        return quantity > 0;
    }

    /**
     * Dispenses the product if available.
     *
     * @return true if the product was successfully dispensed, false otherwise
     */
    public boolean dispense() {
        if (isAvailable()) {
            quantity--;
            logger.info("Dispensed: " + name);
            return true;
        }
        logger.warning("Attempted to dispense out of stock product: " + name);
        return false;
    }
}