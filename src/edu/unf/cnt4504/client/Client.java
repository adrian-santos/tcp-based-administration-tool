package edu.unf.cnt4504.client;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Represents a single client with a request for the server.
 * The client will record the server's response, and the response time for its most recent connection.
 * @author Brandon
 *
 */
public class Client implements Runnable {
	
	//Connection information
	final private InetAddress hostName;
	final private int port;
	

	//Configurable state
	/**
	 * The request this Client has for the server. Must be a Message
	 * @see edu.unf.cnt4504.Message
	 */
	private String request;
	/**
	 * The response from the server, obtained from the most recent run. Any string.
	 */
	private String response;
	/**
	 * The response time for the most recent run. Measured in nanoseconds (ns)
	 */
	private long responseTime;
	
	/**
	 * Creates a new Client that will always connect to the given machine and port
	 * @param hostName ip address of the machine
	 * @param port port number
	 */
	public Client(InetAddress hostName, int port) {
		this.hostName = hostName;
		this.port = port;
	}
	
	/**
	 * Requests a response from the server, and measures the time it takes for the server to respond.
	 */
	@Override
	public void run() {
		System.out.println("Client trying to connect");
		try (Socket socket = new Socket(hostName, port);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			InputStreamReader in = new InputStreamReader(socket.getInputStream());
		) {
			//For building the server response
			StringBuilder sb = new StringBuilder();
			int c;
			
			System.out.println("Client connected to " + hostName + ":" + port);
			long initialTime = System.nanoTime();
			
			out.println(request);
			System.out.println("Client sent request");

			while ((c = in.read()) != -1) {
				sb.append((char)c);
			}

			responseTime = System.nanoTime() - initialTime;
			response = sb.toString();
			System.out.println("Client received response");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the request message
	 * @param message the request to send to the server
	 * @see edu.unf.cnt4504.Message
	 */
	public void setRequest(String message) {
		request = message;
	}

	/**
	 * Gets the response for the most recent run
	 * @return the response from the server
	 */
	public String getResponse() {
		return response;
	}
	
	/**
	 * Gets the response time, in nanoseconds, for the most recent run
	 * @return the response time in nanoseconds (ns)
	 */
	public long getResponseTime() {
		return responseTime;
	}
}
