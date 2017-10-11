
package edu.unf.cnt4504.client;

import java.net.InetAddress;

/*
Client Parallelizer - A class that simulates multiple clients.
It needs to know how many clients, the hostname and port for them each to connect to.
This will encapsulate the many clients/threads.
It should also calculate the mean server response time for a given request (requirement),
as well as the responses for each request.

Written by: Adrian Santos and Kevan Johnston
Date: 09/28/2017 
*/
public class ClientParallelizer {

	private Client[] clients;

    	/**
     	* Constructs a new Parallelizer that will always connect to the given host and port,
     	* and will simulate the given number of clients
     	* @param hostName the host to connect to
     	* @param port the port
     	* @param numClients the number of clients to simualate
     	*/
    	public ClientParallelizer(InetAddress hostName, int port, int numClients){
    		clients = new Client[numClients];
    		for (int i = 0; i < clients.length; i++) {
    			clients[i] = new Client(hostName, port);
    		}
    	}
    
    	/**
     	* Configures all of the clients in this Parallelizer to make the given request
     	* @param request the request to set for all clients
     	*/
	public void setRequest(String request){
        	for (Client client: clients) {
            		client.setRequest(request);
        	}
	}

	/**
	 * Runs the clients in parallel, and waits for all of their connections to end
	 */
	public void runClients(){
		Thread[] threads = new Thread[clients.length];
		//Create threads
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(clients[i]);
		}
        	//Start threads
		for (Thread thread : threads) {
			thread.start();
		}
		//Join threads
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    	}

	/**
	 * Gets the mean response time for this Parallelizer's clients, in ns
	 * @return the mean response time in nanoseconds (ns)
	 */
	public long getMeanResponseTime(){
		long responseTime = 0;

        	for(Client client: clients){
            		responseTime += client.getResponseTime();
        	}

        	return responseTime / clients.length;
    	}

      	/**
     	 * Gets the response from this Parallelizer
     	 * @return the response from the server
	 */
    	public String getResponse(){
    		//The parallelizer arbitrarily decides to use the very first client
    		//as the response
    		return clients[0].getResponse();
    	}
}
