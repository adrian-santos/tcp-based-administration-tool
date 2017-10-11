package edu.unf.cnt4504.client;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.unf.cnt4504.Message;

/* This is the menu for the CNT4504 group project.
 *  The project's purpose is to demonstrate client-server communication.
 *  Written by: Kevan Johnston and Adrian Santos
 *  Date: 9/7/17
 */

public class Menu {
	public static void main(String[] args) {

		int command = 0; // user option
		int loop = 1; // Continue?

		Scanner input = new Scanner(System.in);

		if (args.length < 2) {
			System.err.println("ERROR: usage: ip port [clients]");
			return;
		}// check for command line arguments

		InetAddress hostName;
		try {
			hostName = InetAddress.getByName(args[0]);
		} catch (UnknownHostException e) {
			System.err.println("ERROR: bad server hostname.");
			return;
		}
		
		int port;
		try {
			port = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.err.println("ERROR: bad port number!");
			return;
		}

		//Upper bound: largest unsigned 16 bit integer
		if (0 > port || port > ((1 << 16) - 1)) {
			System.err.println("ERROR: port number out of range!");
			return;
		}

		int numClients;
		if (args.length < 3) {
			numClients = 1; //Default to 1 client
		} else {
			try {
				numClients = Integer.parseInt(args[2]);
			} catch (NumberFormatException e) {
				System.err.println("ERROR: bad number of clients");
				return;
			}
			
			if (numClients < 1) {
				System.err.println("ERROR: number of clients must be positive");
				return;
			}
		}
		
		ClientParallelizer cp = new ClientParallelizer(hostName, port, numClients);

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
					cp.setRequest(Message.CURRENT_DATE_AND_TIME);
					break;
				case 2: // GET UPTIME
					cp.setRequest(Message.UPTIME);
					break;
				case 3: // GET MEMORY USE
					cp.setRequest(Message.MEMORY_USE);
					break;
				case 4: // GET NETSTAT
					cp.setRequest(Message.NETSTAT);
					break;
				case 5: // GET CURRENT USERS
					cp.setRequest(Message.CURRENT_USERS);
					break;
				case 6: // GET RUNNING PROCESSES
					cp.setRequest(Message.RUNNING_PROCESSES);
					break;
			}
			// GET SERVER RESPONSE
			cp.runClients();
			System.out.print(cp.getResponse());
			System.out.flush();
			// GET MEAN SERVER RESPONSE TIME.
			System.out.println("Mean server response time (ns): " + cp.getMeanResponseTime());
		} while (loop == 1);// end do-while
	}// end main
}// end menu
