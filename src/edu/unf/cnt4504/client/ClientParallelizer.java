
package edu.unf.cnt4504.client;

/*
Client Parallelizer - A class that simulates multiple clients.
It needs to know how many clients, the hostname and port for them each to connect to.
This will encapsulate the many clients/threads.
It should also calculate the mean server response time for a given request (requirement),
as well as the responses for each request.

Adrian Santos
*/

import java.lang.*;
import java.io.*;
import java.util.*;
import java.net.*;

public class ClientParallelizer {
	
    public ClientParallelizer(int hostAddress, int port, int client){
        //Check Host name and ports they connect to
        this.hostAddress = hostAddress;
        this.port = port;
        this.client = client;
    }
    
    public countClients(){
      //Count clients
        int clients = 0; //Change variable count
      
        for(int i = 0; i > clients.count; i++){
            clients += 1;
        }
        
        System.out.println("The total number of clients is" + clients);
    
    }
    
    //Host name checker
	public hostName(){
	
	
	}

    
   
    //Calculates the mean server response time and response for a given request
    
     /* * * * * * * * Test Code 1 * * * * * * * */
    long[] arrayTimes = new long[50];
    int numTimes;


    public new Client() {
        numTimes = 0;
    }

    public synchronized void push (long time) {
        arrayTimes[numTimes] = time;
        numTimes++;
    }




    public double getAverage () {
        double averageTime = 0;

        for (int count = 0; count < numTimes; count++)
            averageTime += (double)arrayTimes[count];

        averageTime = averageTime / (double)arrayTimes.length;

        return averageTime;

    }
    
    
    
    /* * * * * * * * Test Code 2 * * * * * * * */
   long[] times;
   int counter;

	public threadTime(int n) {
      times = new long[n];
	  counter = 0;
	}

	public synchronized void add (long t) {
		times[counter++] = t;
	}
	
	
	public double getAverage (int num) {
		double avg = 0;
		
		for (int i = 0; i < num; i++)
			avg += (double)times[i];
	
		   avg = avg / (double)times.length;
		
		return avg;
	}	

}
