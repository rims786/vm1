package com.example.vm.simulation;

import com.example.vm.domain.Product;
import com.example.vm.domain.VendingMachine;
import com.example.vm.exceptions.VendingMachineException;
import com.example.vm.input.UserInputHandler;
import com.example.vm.service.VendingMachineService;

import java.util.logging.Logger;

/**
 * A simulator for the Vending Machine application.
 */
public class VendingMachineSimulator {
    private static final Logger logger = Logger.getLogger(VendingMachineSimulator.class.getName());
    private final VendingMachine vendingMachine;
    private final VendingMachineService vendingMachineService;
    private final UserInputHandler userInputHandler;

    /**
     * Constructs the simulator with a new Vending Machine and Service.
     */
    public VendingMachineSimulator() {
        this.vendingMachine = new VendingMachine();
        this.vendingMachineService = new VendingMachineService(vendingMachine);
        this.userInputHandler = new UserInputHandler();
        setUpVendingMachine();
    }

    /**
     * Sets up the vending machine with initial products.
     */
    private void setUpVendingMachine() {
        vendingMachine.addProduct(new Product("Coke".toLowerCase(), 1.25, 5));
        vendingMachine.addProduct(new Product("Pepsi".toLowerCase(), 1.00, 3));
        vendingMachine.addProduct(new Product("Water".toLowerCase(), 0.75, 10));
        logger.info("Vending machine setup complete with initial products.");
    }

    /**
     * Runs the simulation for user interaction.
     */
    public void run() {
        while (true) {
            vendingMachine.displayProducts();
            String productName = userInputHandler.getProductName();
            if (productName.equalsIgnoreCase("exit")) {
                logger.info("Exiting the vending machine simulation.");
                break;
            }
            double amountInserted = userInputHandler.getAmountInserted();
            userInputHandler.consumeNewline(); // Consume newline

            try {
                vendingMachineService.purchase(productName, amountInserted);
            } catch (VendingMachineException e) {
                System.out.println(e.getMessage()); // Display error message to the user
            }
        }
        userInputHandler.close(); // Close the scanner resource
    }
}