/* This is the menu for the CNT4504 group project.
 *  The project's purpose is to demonstrate client-server communication.
 *  Written by: Kevan Johnston
 *  Date: 9/7/17
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {
 public static void main(String[] args) {
  
  int command = 0; //user option
  int loop; //Continue?
  float time = 0; //mean server response time

  Scanner input = new Scanner(System.in);

  if(args.length == 0) {
   System.out.println("ERROR: no server hostname.");
   return;
   }//check for command line arguments

  String server = args[0];

  ////
  System.out.println("Server: " + server); //TEST
  ////

  do {

  loop = 1; //Continue.
   
  System.out.println("This is a client program that communicates with a server.");
  System.out.println("Please enter a number to request information from the server.");
  System.out.println("Options:");
  System.out.println("1. Host current Date and Time");
  System.out.println("2. Host uptime");
  System.out.println("3. Host memory use");
  System.out.println("4. Host Netstat");
  System.out.println("5. Host current users");
  System.out.println("6. Host running processes");
  System.out.println("7. Quit");
  System.out.println("Please enter the number of the command to be");
  System.out.print("executed: "); //display menu

  try {
   command = input.nextInt();
  }catch(InputMismatchException e) {
   System.out.println("ERROR: invalid user command.");
   System.out.println("Command must be an integer and be");
   System.out.println("between 1 and 7 inclusive.");
   input.nextLine();
   continue;
  }//Check user input for invalid data type.

  if((command < 1) || (command > 7)) {
    System.out.println("ERROR: invalid user command.");
    System.out.println("Command must be between 1 and 7 inclusive.");
    continue;
  }//Check user input for invalid digit.

  if(command == 7) {
   loop = 0;
   continue;
  }//Check for quit command.
  
  //Process information request.
  ////
  if(command == 1) {
   //METHOD CALL TO GET DATE AND TIME
   System.out.println("Date and Time command accepted.");//TEST
  }
  ////
  
  ////
  if(command == 2) {
   //METHOD CALL TO GET UPTIME
   System.out.println("Uptime command accepted.");//TEST
  }
  ////
  
  ////
  if(command == 3) {
   //METHOD CALL TO GET MEMORY USE
   System.out.println("Memory use command accepted.");//TEST
  }
  ////
  
  ////
  if(command == 4) {
   //METHOD CALL TO GET NETSTAT
   System.out.println("Netstat command accepted.");//TEST
  }
  ////
  
  ////
  if(command == 5) {
   //METHOD CALL TO GET CURRENT USERS
   System.out.println("Current users command accepted.");//TEST
  }
  ////
  
  ////
  if(command == 6) {
   //METHOD CALL TO GET RUNNING PROCESSES
   System.out.println("Running processes command accepted.");//TEST
  }
  ////
  
  //GET RESPONSE.

  //DISPLAY RESPONSE.
  
  //GET MEAN SERVER RESPONSE TIME.
  System.out.println("Mean server response time: " + time); //mean server response time

  }while( loop == 1 );//end do-while
 }//end main
}//end menu 
