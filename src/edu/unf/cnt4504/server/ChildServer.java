package edu.unf.cnt4504.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Simulates a single server that will serve a Client over a TCP connection
 * @author Brandon
 *
 */
public class ChildServer implements Runnable {

	private ServerSocket socket;
	
	/**
	 * Constructs a new Child Server that will listen for a Client to connect on the given socket
	 * @param socket the socket to listen on
	 */
	public ChildServer(ServerSocket socket) {
		this.socket = socket;
	}
	
	/**
	 * Listens for a connection while blocking, and then accepts a single connection and serves that Client.
	 */
	@Override
	public void run() {
		try (Socket client = socket.accept();
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
				new InputStreamReader(client.getInputStream()));
		) {
			System.out.println("Server accepted connection " + client.getInetAddress().getHostAddress());
				
			String request = in.readLine();
			System.out.println("Server received request");
			
			//TODO Requires the Responder to be implemented.
			//out.println(response)
			System.out.println("Server sent response");
		} catch (IOException e){
			e.printStackTrace();
		}
		System.out.println("Server connection ended");
	}
}
