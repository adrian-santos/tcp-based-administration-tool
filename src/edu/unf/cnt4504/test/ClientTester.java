package edu.unf.cnt4504.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import edu.unf.cnt4504.Message;
import edu.unf.cnt4504.client.ClientParallelizer;

public class ClientTester {
	
	public static void main(String[] args) {
		if (args.length < 2) {
			System.err.println("ERROR: usage: ip port");
			return;
		}
		
		InetAddress hostName;
		try {
			hostName = InetAddress.getByName(args[0]);
		} catch (UnknownHostException e) {
			System.err.println("ERROR: bad ip");
			return;
		}
		
		int port;
		try {
			port = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.err.println("ERROR: bad port");
			return;
		}
		
		//Upper bound: largest unsigned 16 bit integer
		if (0 > port || port > ((1 << 16) - 1)) {
			System.err.println("ERROR: port out of range");
			return;
		}
		
		int[] clientCounts = {
			1, 5, 10, 20, 30, 40, 50, 60, 70, 75
		};
		long[] dates = new long[clientCounts.length];
		long[] netstats = new long[clientCounts.length];	
		ClientParallelizer cp;	
		for (int i = 0; i < clientCounts.length; i++) {
			cp = new ClientParallelizer(hostName, port, clientCounts[i]);
			cp.setRequest(Message.CURRENT_DATE_AND_TIME);
			cp.runClients();
			dates[i] = cp.getMeanResponseTime();
			
			cp.setRequest(Message.NETSTAT);
			cp.runClients();
			netstats[i] = cp.getMeanResponseTime();	
		}

		System.out.printf("|%10s|%15s|%15s|\n", "Clients", "Date", "Netstat");
		System.out.printf("|%10s+%15s+%15s|\n", "----------", "---------------", 
			"---------------");
		for (int i = 0; i < clientCounts.length; i++) {
			System.out.printf("|%10d|%15d|%15d|\n", clientCounts[i], 
				dates[i], netstats[i]);
		}
		System.out.flush();
	}
}
