package com.example.vm.domain;

import com.example.vm.domain.Product;
import com.example.vm.domain.VendingMachine;
import com.example.vm.service.VendingMachineService;
import com.example.vm.exceptions.VendingMachineException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the VendingMachine class.
 */
public class VendingMachineTest {
    private VendingMachine vendingMachine;
    private VendingMachineService vendingMachineService;
    private static final Logger logger = Logger.getLogger(VendingMachineTest.class.getName());

    /**
     * Sets up a new VendingMachine instance and service before each test.
     */
    @BeforeEach
    public void setUp() {
        vendingMachine = new VendingMachine();
        vendingMachineService = new VendingMachineService(vendingMachine);
        vendingMachine.addProduct(new Product("Coke", 1.25, 5));
        vendingMachine.addProduct(new Product("Pepsi", 1.00, 0));
    }

    /**
     * Tests a successful purchase of a product.
     */
    @Test
    public void testPurchaseSuccess() {
        logger.info("Testing successful purchase of Coke.");
        try {
            vendingMachineService.purchase("Coke", 1.50);
            assertEquals(4, vendingMachine.getProduct("Coke").getQuantity(), "Coke quantity should decrease to 4 after purchase.");
        } catch (VendingMachineException e) {
            fail("Purchase should have been successful: " + e.getMessage());
        }
    }

    /**
     * Tests the behavior when attempting to purchase an out-of-stock product.
     */
    @Test
    public void testPurchaseOutOfStock() {
        logger.info("Testing purchase of out-of-stock product (Pepsi).");
        try {
            vendingMachineService.purchase("Pepsi", 1.00);
            fail("Expected VendingMachineException for out-of-stock product.");
        } catch (VendingMachineException e) {
            assertEquals("Product is out of stock.", e.getMessage());
        }
    }

    /**
     * Tests the behavior when not enough money is inserted for a product.
     */
    @Test
    public void testPurchaseNotEnoughMoney() {
        logger.info("Testing purchase with insufficient funds for Coke.");
        try {
            vendingMachineService.purchase("Coke", 1.00);
            fail("Expected VendingMachineException for insufficient funds.");
        } catch (VendingMachineException e) {
            assertEquals("Not enough money inserted.", e.getMessage());
        }
    }

    /**
     * Tests the behavior when trying to purchase a product that does not exist.
     */
    @Test
    public void testPurchaseProductNotFound() {
        logger.info("Testing purchase of a non-existent product.");
        try {
            vendingMachineService.purchase("Sprite", 1.50);
            fail("Expected VendingMachineException for non-existent product.");
        } catch (VendingMachineException e) {
            assertEquals("Product not found.", e.getMessage());
        }
    }
}