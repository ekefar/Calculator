package com.teamdev.students.calculator.client.console;

import com.teamdev.students.calculator.services.CalculationServicesFactory;
import com.teamdev.students.calculator.services.api.CalculationException;
import com.teamdev.students.calculator.services.api.CalculationService;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Represents simple console client, that provides dialog with user
 */
public class ConsoleClient {
    // user`s input
    Scanner input;

    public ConsoleClient() {
        input = new Scanner(System.in);

    }

    /**
     * Begin dialog with user
     */
    public void startDialog() {
        String choice = "";
        // while answer is not 'n'
        while (!choice.toUpperCase().equals("N")) {
            out.print("Input math expression: ");

            // read math expression
            String expression = input.nextLine();

            // create calculation service
            CalculationService calculationService = CalculationServicesFactory.createSimpleCalculationService();

            // try to calculate
            try {
                double answer = calculationService.calculate(expression);
                out.println("Answer is " + answer);
            } catch (CalculationException e) {
                // if failure - show error info
                char invalidToken = expression.charAt(e.getInvalidTokenPosition());
                out.println("'" + invalidToken + "'" + " at " + (e.getInvalidTokenPosition() + 1) + ", " + e.getMessage());

            } catch (Exception e1) {
                out.println(e1.getMessage());
            } finally {

                // ask about next move
                out.println();
                out.print("Try again? (y/n): ");
                choice = input.nextLine();
                out.println();
                out.println();
            }
        }
    }

    /**
     * Begin dialog with user
     *
     * @param greeting initial greeting
     */
    public void startDialog(String greeting) {
        out.println();
        out.println();
        out.println(greeting);

        startDialog();
    }
}
