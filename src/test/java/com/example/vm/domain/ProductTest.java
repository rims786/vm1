package com.example.vm.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.logging.Logger;

/**
 * Unit tests for the Product class.
 */
public class ProductTest {

    private static final Logger logger = Logger.getLogger(ProductTest.class.getName());

    /**
     * Tests the availability of a product based on its quantity.
     */
    @Test
    public void testProductAvailability() {
        // Create a product with 0 quantity
        Product product = new Product("Test Product", 1.00, 0);
        assertFalse(product.isAvailable(), "Product should not be available when quantity is 0.");

        // Change quantity to 1 and test again
        product = new Product("Test Product", 1.00, 1);
        assertTrue(product.isAvailable(), "Product should be available when quantity is greater than 0.");
    }

    /**
     * Tests the dispense method of the Product class.
     */
    @Test
    public void testDispense() {
        // Create a product with 1 quantity
        Product product = new Product("Test Product", 1.00, 1);

        // Dispense the product
        assertTrue(product.dispense(), "Product should be dispensed successfully.");
        assertEquals(0, product.getQuantity(), "Quantity should decrease to 0 after dispensing.");

        // Attempt to dispense again and expect failure
        assertFalse(product.dispense(), "Should not be able to dispense an out-of-stock product.");
    }
}