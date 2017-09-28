package edu.unf.cnt4504.client;

import java.util.Scanner;
import java.util.InputMismatchException;

/* This is the menu for the CNT4504 group project.
 *  The project's purpose is to demonstrate client-server communication.
 *  Written by: Kevan Johnston and Adrian Santos
 *  Date: 9/7/17
 */

public class Menu {
	public static void main(String[] args) {

		int command = 0; // user option
		int loop = 1; // Continue?
		long time = 0; // mean server response time

		Scanner input = new Scanner(System.in);

		if (args.length == 0) {
			System.out.println("ERROR: no server hostname.");
			return;
		}// check for command line arguments

		String server = args[0];

		ClientParallelizer cp = new ClientParallelizer(server, 8080, 2);
		Message msg = new Message();

		do {
			System.out.println("This is a client program that communicates with a server.");
			System.out.println("Please enter a number to request information from the server.");
			System.out.println("Options:");
			System.out.println("1. Host current Date and Time");
			System.out.println("2. Host uptime");
			System.out.println("3. Host memory use");
			System.out.println("4. Host Netstat");
			System.out.println("5. Host current users");
			System.out.println("6. Host running processes");
			System.out.println("7. Quit");
			System.out.println("Please enter the number of the command to be");
			System.out.print("executed: "); // display menu

			try {
				command = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("ERROR: invalid user command.");
				System.out.println("Command must be an integer and be");
				System.out.println("between 1 and 7 inclusive.");
				input.nextLine();
				continue;
			}// Check user input for invalid data type.

			if ((command < 1) || (command > 7)) {
				System.out.println("ERROR: invalid user command.");
				System.out.println("Command must be between 1 and 7 inclusive.");
				continue;
			}// Check user input for invalid digit.

			// Process information request.
			switch(command) {
				case 7: // Check for quit command.
					loop = 0;
					continue;
				case 1: // GET DATE AND TIME
					cp.setRequest(msg.CURRENT_DATE_AND_TIME);
					cp.runClients();
					String response = cp.getResponse();
					System.out.println(response);
					break;
				case 2: // GET UPTIME
					cp.setRequest(msg.UPTIME);
					cp.runClients();
					String response = cp.getResponse();
					System.out.println("Uptime: " + response);
					break;
				case 3: // GET MEMORY USE
					cp.setRequest(msg.MEMORY_USE);
					cp.runClients();
					String response = cp.getResponse();
					System.out.println("Memory Usage: " + response);
					break;
				case 4: // GET NETSTAT
					cp.setRequest(msg.NETSTAT);
					cp.runClients();
					String response = cp.getResponse();
					System.out.println("NETSTAT: " + response);
					break;
				case 5: // GET CURRENT USERS
					cp.setRequest(msg.CURRENT_USERS);
					cp.runClients();
					String response = cp.getResponse();
					System.out.println("Current Users: " + response);
					break;
				case 6: // GET RUNNING PROCESSES
					cp.setRequest(msg.RUNNING_PROCESSES);
					cp.runClients();
					String response = cp.getResponse();
					System.out.println("Running Processes: " + response);
					break;
			}

			// GET MEAN SERVER RESPONSE TIME.
			System.out.println("Mean server response time: " + time);
		} while (loop == 1);// end do-while
	}// end main
}// end menu
