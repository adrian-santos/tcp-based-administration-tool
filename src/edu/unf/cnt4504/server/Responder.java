package edu.unf.cnt4504.server;

public class Responder {
    public getResponse (String message) {


        switch (message) {

            case 1:
                cmd = "date";
                break;


            case 2:
                cmd = "uptime";
                break;

            case 3:
                cmd = "free";
                break;

            case 4:
                cmd = "netstat";
                break;

            case 5:
                cmd = "who";
                break;

            case 6:
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

