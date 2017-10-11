package edu.unf.cnt4504.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Simulates a single server that will serve a Client over a TCP connection
 * @author Brandon
 *
 */
public class ChildServer implements Runnable {

	final private Socket client;
	final private Responder responder;
	
	/**
	 * Constructs a new Child Server that will serve the client
	 * @param client the client to serve
	 */
	public ChildServer(Socket client) {
		this.client = client;
		responder = new Responder();
	}
	
	/**
	 * Serves this child server's client.
	 */
	@Override
	public void run() {
		try (PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
				new InputStreamReader(client.getInputStream()));
		) {
			System.out.println("Server accepted connection " + client.getInetAddress().getHostAddress());
				
			String request = in.readLine();
			System.out.println("Server received request");
			
			String response = responder.getResponse(request);
			out.print(response);
			out.flush();
			System.out.println("Server sent response");
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("Server connection ended");
	}
}
