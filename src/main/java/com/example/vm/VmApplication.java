package com.example.vm;


import com.example.vm.simulation.VendingMachineSimulator;

/**
 * The main application for the vending machine.
 */
public class VmApplication {
	/**
	 * The main method that runs the vending machine application.
	 *
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		VendingMachineSimulator simulator = new VendingMachineSimulator();
		simulator.run();
	}
}