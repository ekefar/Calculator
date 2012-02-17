package com.teamdev.students.calculator.services.commands;

/**
 * Represents action of '*' operation of two double numbers
 */
public class MultiplyCommand implements Command {

    // command arguments
    Double[] arguments;

    public MultiplyCommand(Double... args) {
        arguments = args;
    }

    /**
     * Execute command and return result
     *
     * @return result of calculations
     */
    @Override
    public double execute() {

        double arg1 = arguments[0];
        double arg2 = arguments[1];

        return arg1 * arg2;
    }

}
