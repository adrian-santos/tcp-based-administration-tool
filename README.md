# CNT4504
This is the networks project
 
Project #1
This client-server programming project is an iterative TCP based network administration tool. The server provides current system status as requested from the client. The client can request from the server such information as the system time, the uptime, the memory use, netstat, current users, and the running processes. The client program displays a text menu for the user. The user makes requests by selecting a menu option. 

The user will enter the server hostname as a command line argument when the client program is invoked. If there is no command line argument then the program will print an error message and exit. The client program then enters a loop until told to quit where it will:

•	Display a menu 
•	Prompt the user for a command
•	Test user input for command validity. If user command is invalid, inform the user and redisplay the menu.
•	Send that command request to the server on the host
•	Get response back from server
•	Display response for user

The menu will provide the following choices to the user:
1.	Host current Date and Time
2.	Host uptime
3.	Host memory use
4.	Host Netstat
5.	Host current users
6.	Host running processes
7.	Quit

Have your server print out diagnostic messages about what it is doing (e.g., “accepting a new connection”, etc.)


You may use the popen() library function to get the output of a command into your program. Here’s a code fragment to experiment with and see how popen() works:
	

	char buf[100];
	FILE *fp = popen(“who”, “r”);
	
	while (fgets(buf, 100, fp) != NULL)
		printf(“%s\n”, buf);

You will be required to provide a demo to the instructor. The client-server application will be tested for compliance with all requirements listed above. 
Your code will be expected to deal with invalid user commands. You will turn in binaries and source code of your client and server programs at the time of the demo. 

Plot two graphs of the latency (mean server response time) versus number of clients for the netstat and current date and time commands.  Increase the number of clients as follows: 1, 5, 10, 20, 30, 40, 50, 60, 70, 75. 

 
Project #2
Make your server concurrent by having it spawn a thread/process to handle each client request. 

Plot two graphs of the latency (mean server response time) versus number of clients for the netstat and current date and time commands.  Increase the number of clients as follows: 1, 5, 10, 20, 30, 40, 50, 60, 70, 75.

Paper
The paper must be well written and must have the sections listed below.
(Paper length: 8-9 pages including diagrams, graphs, and references. Paper is single-spaced and in single column format. Each group submits one paper.)

Abstract
Describe what your project is about; what are its goals (i.e. comparison of distributed application development paradigms); what experiments were conducted. The abstract must be concise. Try not to exceed 150 words. 

1.0 Introduction
First describe your project in greater depth, i.e. explain your goals, and include an explanation of the client-server set-up.


2.0 Distributed Application Development
You will describe both the paradigms (describe Iterative Approach in Section 2.1 and Concurrent Approach in Section 2.2). Be sure to provide references when you refer to texts, papers, and websites etc. to describe these paradigms. Include a description (including the function prototype) of the major socket calls used (e.g. socket(), bind() etc). 

3.0 Results and Comparisons

3.1 Test Bed
Describe the configuration and specifications of the client and server machines in terms of hardware and the operating system used. Also specify which LAN was used.

3.2 Studies carried out
First describe the studies carried out, i.e. which metrics were measured (in this case latency), how they were measured, and which graphs were plotted.

3.3. Results 
Provide the results by referring the reader to your graph(s) where you compare the performance of the iterative and concurrent servers. Explain your results. 

4.0 Conclusions
Provide your conclusions, insights that you have gained in this section (which server shows better performance and why). 

References
Use the following IEEE standard when listing references:
[1] Ahuja, Sanjay, P., Quintao, R., and Basavanahally, S., An Empirical Analysis of the Performance of CORBA and Java RMI: Distributed Open Object Architectures for Internet Based Applications, Proceedings of the 2001 International Symposium on Performance Evaluation of Computer and Telecommunication Systems (SPECTS 2001), Orlando, FL, July 2001.


DESIGN SECTION

There seem to be about 6 major classes that we'll need to implement. Some are more involved than others. 

1.	Menu/Client Program - Essentially a main method, with any other needed private methods. This will need the menu to interact with the user through standard I/O (requirement). The menu needs to perform error checking on user input, and have a Quit option (requirement). Each of the 6 menu options will correlate to 1 ot 6 method calls to the Clients. The menu will probably also have to display mean server response time, which is just a method call to the clients. 

Skills: basic looping/condition checking/exception handling
API: A main method, the first String arg is the hostname that the clients connect to.

2.	Client Parallelizer - A class that simulates multiple clients. It needs to know how many clients, the hostname and port for them each to connect to. This will encapsulate the many clients/threads. It should also calculate the mean server response time for a given request (requirement), as well as the responses for each request. 

Skills: basic looping/threads
API: get mean response time, get current date and time, ... , get netstat, etc.

3.	Client - Corresponds to a single client with a request. This will encapsulate 1 end of a connection. It needs to know the hostname and port to connect to, as well as the request it should have. It should also calculate the server response time (for this instance, not a mean server response time) for its request. It will have to communicate using TCP, and whoever writes this may have to coordinate with another to help write the protocol that our client/servers will use. It should implement Runnable, so that it can be placed inside a thread

Skills: TCP sockets
API: get response time, get server response

4.	Server/ChildServer - Corresponds to a single child server to handle a request. This encapsulates the other end of the connection. It should communicate with a Client instance over TCP and will send the response back. To obtain the response to a given request, it should call a method that handles a request. This class should also print diagnostic messages to the server machines standard output (requirement). For project 2, it will need to be Runnable, so that it can be placed inside a thread. For now, that's irrelevant.

Skills: TCP sockets
API: none to speak of

5.	Response Generator/Responder - A class containing a method (and any other private helper methods) that will return the response to a request. The server machine will have this class in memory, and this class should run various commands on the OS to find the appropriate information (like date & time and memory use). I imagine that our server will run some sort of Linux server OS but I'm not sure.

Skills: Running processes and commands on the OS
API: get response

6.	Server/Master Server Program - Essentially a main method. The server machine will run this. This should open a server socket and listen on a port, and then loop forever: accept a connection, create a child server, and then run the child server. Rinse and repeat. The clients will be served in sequence, rather than in parallel. In project 2, this class would start a new thread for each child server/connection it accepts.

Skills: basic basic b a s i c looping/TCP serversockets
API: command line args unused

Remarks: We'll need some sort of enum or a-bunch-of-constants (6) to correspond to the 6 different messages; Clients will need to connect to the same port that the server program listens on; If anyone wants to test the client/server on one machine, then they'll just start up both client program/server program in seperate threads and start and join them; 
