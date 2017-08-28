package edu.unf.cnt4504;

/**
 * Contains string enumerations for the 6 kinds of messages that our clients and servers use.
 * 
 * @author Brandon
 *
 */
public class Message {
	private Message () { }
	
	public static final String CURRENT_DATE_AND_TIME = "B";
	public static final String UPTIME = "C";
	public static final String MEMORY_USE = "D";
	public static final String NETSTAT = "E";
	public static final String CURRENT_USERS = "F";
	public static final String RUNNING_PROCESSES = "G";
}
