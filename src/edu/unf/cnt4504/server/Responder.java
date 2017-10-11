package edu.unf.cnt4504.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.stream.Collectors;

import edu.unf.cnt4504.Message;

/*
Response Generator/Responder - A class containing a method (and any other private helper methods) that will return the response to a 
request. The server machine will have this class in memory, and this class should run various commands on the OS to find the appropriate
information (like date & time and memory use).
*/
public class Responder {
	
	/**
	 * Get a response for the request
	 * @param request the request to respond to
	 * @return the response
	 */
	public String getResponse(String request) throws IOException {
		String cmd = requestToLinuxCommand(request);
		Process p = Runtime.getRuntime().exec(cmd);
		try (BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
			StringBuilder result = new StringBuilder();
			char[] buffer = new char[1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				result.append(buffer, 0, length);
			}
			try {
				p.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
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


