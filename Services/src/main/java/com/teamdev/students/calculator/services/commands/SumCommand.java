package com.teamdev.students.calculator.services.commands;

/**
 * Represents command, that finds mmin value of it`s arguments
 */
public class SumCommand implements Command {

    // command arguments
    Double[] arguments;

    public SumCommand(Double... args) {
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
        for (double value : arguments) {
            result += value;
        }
        return result;
    }
}
