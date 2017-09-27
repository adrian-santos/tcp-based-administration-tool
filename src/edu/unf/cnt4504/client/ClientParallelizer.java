
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

public class ClientParallelizer {
    public static void main(String[] args){

        //Count clients
        int clients = 0; //Change variable count
        int clientCount = 0;


        for(clients = 0; clients > clients.count; clients++){
            clientCount += 1;
        }

        //Check Host name and ports they connect to


    }
    //Calculates the mean server response time and response for a given request
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



}
