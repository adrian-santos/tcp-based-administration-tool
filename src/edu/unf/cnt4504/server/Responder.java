package edu.unf.cnt4504.server;

public class Responder {
    public getResponse (String Message) {
        return getResponse;

        switch (caseNum) {
            case 1:
                someRuntime = Runtime.getRuntime();
                cmd = "date";

                // Runs the process, gets the ouptut, and prints it on the client side
                sProcess = sRuntime.exec(cmd);
                stdInp = (new InputStreamReader(someProcess.getInputStream()));

                // Sets the output to blank so that all previous outputs will not be concatenated
                output = "";
                break;


            case 2:

                // Creates a process for running processes
                someRuntime = Runtime.getRuntime();
                cmd = "uptime";

                // Runs the process, gets the ouptut, and prints it on the client side
                sProcess = sRuntime.exec(cmd);
                stdInp = (new InputStreamReader(someProcess.getInputStream()));


                // Sets the output to blank so that all previous outputs will not be concatenated
                output = "";
                break;

            case 3:

                // Creates a process for running processes
                someRuntime = Runtime.getRuntime();
                cmd = "free";

                // Runs the process, gets the ouptut, and prints it on the client side
                sProcess = sRuntime.exec(cmd);
                stdInp = (new InputStreamReader(someProcess.getInputStream()));

                // Sets the output to blank so that all previous outputs will not be concatenated
                output = "";
                break;

            case 4:

                // Creates a process for running processes
                someRuntime = Runtime.getRuntime();
                cmd = "netstat";

                // Runs the process, gets the ouptut, and prints it on the client side
                sProcess = sRuntime.exec(cmd);
                stdInp = (new InputStreamReader(someProcess.getInputStream()));

                // Sets the output to blank so that all previous outputs will not be concatenated
                output = "";
                break;

            case 5:

                // Creates a process for running processes
                someRuntime = Runtime.getRuntime();
                cmd = "who";

                // Runs the process, gets the ouptut, and prints it on the client side
                sProcess = sRuntime.exec(cmd);
                stdInp = (new InputStreamReader(someProcess.getInputStream()));

                // Sets the output to blank so that all previous outputs will not be concatenated
                output = "";
                break;

            case 6:

                // Creates a process for running processes
                someRuntime = Runtime.getRuntime();
                cmd = "ps -e";

                // Runs the process, gets the ouptut, and prints it on the client side
                sProcess = sRuntime.exec(cmd);
                stdInp = (new InputStreamReader(someProcess.getInputStream()));

                // Sets the output to blank so that all previous outputs will not be concatenated
                output = "";
                break;

            case 7:

                System.exit();
                break;


        }
    }
}
