package edu.unf.cnt4504.server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Contains the main method that our server will run.
 * It iteratively instantiates new servers to serve clients in sequence.
 * @author Brandon
 *
 */
public class ServerProgram {
	public static void main(String[] args) {
		//The port that the program will listen on
		final int port = 8080;
		
		try (ServerSocket socket = new ServerSocket(port)) {
			while (true) {
				new ChildServer(socket).run();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
