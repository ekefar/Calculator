package com.teamdev.students.calculator.services.commands;


/**
 * Created by IntelliJ IDEA.
 * Represents action of '+' operation of two double numbers
 */
public class PlusCommand implements Command {

    // command arguments
    Double[] arguments;

    public PlusCommand(Double... args) {
        arguments = args;
    }

    /**
     * Execute command and return result
     *
     * @return result of calculations
     */
    @Override
    public double execute() {
        double result = 0.0;
        for (double value : arguments)
            result += value;

        return result;
    }
}
