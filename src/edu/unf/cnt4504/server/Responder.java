package edu.unf.cnt4504.server;
/*
Response Generator/Responder - A class containing a method (and any other private helper methods) that will return the response to a 
request. The server machine will have this class in memory, and this class should run various commands on the OS to find the appropriate
information (like date & time and memory use).
*/
import java.io.IOException;
import java.io.InputStream;

import edu.unf.cnt4504.Message;

public class Responder {
	
	public String getResponse(String request) throws IOException {
		String cmd = requestToLinuxCommand(request);
		Process p = Runtime.getRuntime().exec(cmd);
		try (InputStream in = p.getInputStream()) {
			StringBuilder result = new StringBuilder();
			int c;
			while ((c = in.read()) != -1) {
				result.append((char)c);
			}
			return result.toString();
		}
	}
	
	private String requestToLinuxCommand(String request) {
		switch (request) {
		case Message.CURRENT_DATE_AND_TIME:
			return "date";
		case Message.CURRENT_USERS:
			return "who";
		case Message.MEMORY_USE:
			return "free";
		case Message.NETSTAT:
			return "netstat";
		case Message.RUNNING_PROCESSES:
			return "ps";
		case Message.UPTIME:
			return "uptime";
		default:
			throw new IllegalArgumentException(request);		
		}
	}
}


