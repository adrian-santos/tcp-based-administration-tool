package edu.unf.cnt4504.server;

import edu.unf.cnt4504.Message;

public class Responder {
    public getResponse (String message) {


        switch (message) {

            case Message.CURRENT_DATE_AND_TIME:
                cmd = "date";
                break;


            case Message.UPTIME:
                cmd = "uptime";
                break;

            case Message.MEMORY_USE:
                cmd = "free";
                break;

            case Message.NETSTAT:
                cmd = "netstat";
                break;

            case Message.CURRENT_USERS:
                cmd = "who";
                break;

            case Message.RUNNING_PROCESSES:
                cmd = "ps -e";
                break;

            case 7:

                System.exit();
                break;


        }

        someRuntime = Runtime.getRuntime();

        // Runs the process, gets the ouptut, and prints it on the client side
        sProcess = sRuntime.exec(cmd);
        stdInp = (new InputStreamReader(someProcess.getInputStream()));

        // Sets the output to blank so that all previous outputs will not be concatenated
        output = "";
    }
}

