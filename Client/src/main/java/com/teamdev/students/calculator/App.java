package com.teamdev.students.calculator;


import com.teamdev.students.calculator.client.console.ConsoleClient;
import com.teamdev.students.calculator.client.swing.SwingClient;

/**
 * Application`s main class
 */
public class App {
    public static void main(String... args) {

        // if console key
        if (args.length > 0 && args[0].equals("-c")) {
            // create console client and start dialog
            ConsoleClient consoleClient = new ConsoleClient();
            consoleClient.startDialog("Welcome, stranger! I`ll show You some math-magic!");
        } else {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new SwingClient();
                }
            });
        }
    }
}
