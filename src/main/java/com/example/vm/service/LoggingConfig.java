package com.example.vm.service;


import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingConfig {
    public static void configureLogging() {
        Logger logger = Logger.getLogger("com.example.vm.service.vendingmachineservice");
        logger.setLevel(Level.WARNING); // Set log level to WARNING to exclude INFO messages

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.WARNING); // Set handler level to WARNING
        logger.addHandler(handler);
    }
}