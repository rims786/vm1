# Vending Machine Application
A Java-based vending machine application that handles product purchases and dispensing with proper logging.
This README provides essential information for users to understand, build, and run the vending machine application.

## Features
- Product purchase handling
- Stock availability checking
- Change calculation
- Transaction logging

## Prerequisites
- Java 8 or higher
- Maven
- Spring Boot 3.3.5

## Building the Application
To build the application, run:
mvn clean install

## Running the Application
To start the application, run:
mvn spring-boot:run

## Usage
The vending machine service allows you to:
Purchase products by providing:
Product name
Amount of money inserted

## The system will:
Verify product availability
Check if sufficient money was inserted
Dispense the product
Calculate and return change
Log all transactions
Error Handling

## The application handles the following scenarios:
Product not found
Product out of stock
Insufficient funds

## Development
This project uses:
Spring Boot



