# CNT4504
This is the networks project

* * * * * * * * * * * * * * * * * * * * * * * * PROJECT 1 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
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


* * * * * * * * * * * * * * * * * * * * * * * * PROJECT 2 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
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

