package edu.unf.cnt4504.client;

public class myThread extends Thread {
    int userChoice;
    PrintWriter output;
    BufferedReader input;
    long totalTime;
    timeStack myTimeStack;

    public myThread (int userChoice, PrintWriter output, BufferedReader input, timeStack myTimeStack) {
        this.userChoice = userChoice;
        this.output = output;
        this.input = input;
        this.myTimeStack = myTimeStack;
    }

    public void run() {
        long totalTime;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();

        output.println(userChoice);

        try {
            String serverInput = "From server: " + input.readLine();
            endTime = System.currentTimeMillis();
            totalTime = endTime - startTime;
            myTimeStack.push(totalTime);
            System.out.println(serverInput);
        } catch(IOException e) {
            System.out.println(e);
        }
    }

}