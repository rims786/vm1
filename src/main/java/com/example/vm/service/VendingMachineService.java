package com.example.vm.service;


import com.example.vm.domain.Product;
import com.example.vm.domain.VendingMachine;
import com.example.vm.exceptions.VendingMachineException;

import java.util.logging.Logger;

/**
 * Service class for handling vending machine operations.
 */
public class VendingMachineService {
    private static final Logger logger = Logger.getLogger(VendingMachineService.class.getName());
    private final VendingMachine vendingMachine;

    public VendingMachineService(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    /**
     * Purchases a product from the vending machine.
     *
     * @param productName   the name of the product to purchase
     * @param amountInserted the amount of money inserted
     * @throws VendingMachineException if the purchase fails
     */
    public void purchase(String productName, double amountInserted) throws VendingMachineException {
        Product product = vendingMachine.getProduct(productName);
        if (product == null) {
            logger.warning("Product not found: " + productName);
            throw new VendingMachineException("Product not found.");
        }

        if (!product.isAvailable()) {
            logger.warning("Product is out of stock: " + productName);
            throw new VendingMachineException("Product is out of stock.");
        }

        if (amountInserted < product.getPrice()) {
            logger.warning("Not enough money inserted for product: " + productName);
            throw new VendingMachineException("Not enough money inserted.");
        }

        product.dispense();
        double change = amountInserted - product.getPrice();
        logger.info("Dispensed: " + productName + ". Change: SEK " + change);
    }
}