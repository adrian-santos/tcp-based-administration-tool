
package edu.unf.cnt4504.client;

/*
Client Parallelizer - A class that simulates multiple clients.
It needs to know how many clients, the hostname and port for them each to connect to.
This will encapsulate the many clients/threads.
It should also calculate the mean server response time for a given request (requirement),
as well as the responses for each request.

Written by: Adrian Santos and Kevan Johnston
Date: 09/28/2017 
*/

import java.lang.*;
import java.io.*;
import java.util.*;
import java.net.*;

public class ClientParallelizer {

    List<Client> clients = new ArrayList<>();

    public ClientParallelizer(InetAddress hostName, int port, int client){
        //Check Host name and ports they connect to
        //Count clients
        for(int i = 0; i < client;i++ ){
            Client clientNumber = new Client(hostName, port);
            clients.add();
        }
    }

    //Calculates the mean server response time and response for a given request
    //Host name checker
	public void setRequest(String request){
        // for each loop
        for (Client client: clients) {
            client.setRequest(request)
        }
	}

	public void runClients(){
        for(Client client: clients){
            client.run();
        }
    }

    public long getMeanResponseTime(){
	    //Response Time
	    long responseTime = 0;

        for(Client client: clients){
            responseTime += client.getResponseTime();
        }

        responseTime /= client;

        return responseTime;
    }

    public String getResponse(){

    }

}
