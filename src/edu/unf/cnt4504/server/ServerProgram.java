package edu.unf.cnt4504.server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Contains some start methods for the server
 * @author Brandon
 *
 */
public class ServerProgram {
	
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("ERROR: No port number!");
			return;
		}
		
		int port;
		try {
			port = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.err.println("ERROR: Bad port!");
			return;
		}
		//Upper bound: Largest unsigned 16 bit integer
		if (port < 0 || port > ((1 << 16) - 1)) {
			System.err.println("ERROR: Port out of range!");
			return;
		}
		System.out.println("Began listening on port " + port + "...");
		startIterativeServer(port);
	}

	private ServerProgram() {}

	/**
	 * Starts an iterative server that will listen on the specified port
	 * @param port the port to listen on
	 *
	 */
	public static void startIterativeServer(int port) {
		try (ServerSocket socket = new ServerSocket(port)) {
			while (true) {
				new ChildServer(socket.accept()).run();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
