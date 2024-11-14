package com.example.vm.input;


import java.util.Scanner;

/**
 * A class to handle user input.
 */
public class UserInputHandler {
    private final Scanner scanner;

    /**
     * Constructs a UserInputHandler instance.
     */
    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prompts the user for a product name to purchase.
     *
     * @return the product name entered by the user
     */
    public String getProductName() {
        System.out.print("Enter the product name to purchase (or 'exit' to quit): ");
        return scanner.nextLine();
    }

    /**
     * Prompts the user for the amount of money inserted.
     *
     * @return the amount inserted as a double
     */
    public double getAmountInserted() {
        System.out.print("Enter the amount inserted: SEK ");
        return scanner.nextDouble();
    }

    /**
     * Consumes the newline character after reading a double.
     */
    public void consumeNewline() {
        scanner.nextLine(); // Consume newline
    }

    /**
     * Closes the scanner resource.
     */
    public void close() {
        scanner.close();
    }
}