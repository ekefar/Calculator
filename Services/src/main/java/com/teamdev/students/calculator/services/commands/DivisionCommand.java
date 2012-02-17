package com.teamdev.students.calculator.services.commands;

/**
 * Represents action of division of two double numbers
 */
public class DivisionCommand implements Command {

    // command arguments
    Double[] arguments;

    public DivisionCommand(Double... args) {
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

        if (arg2 == 0.0)
            throw new ArithmeticException("Division by zero.");

        return arg1 / arg2;
    }

}