package com.example.vm.exceptions;


/**
 * Custom exception for vending machine operations.
 */
public class VendingMachineException extends Exception {
    public VendingMachineException(String message) {
        super(message);
    }
}