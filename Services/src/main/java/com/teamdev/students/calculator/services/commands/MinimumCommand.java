package com.teamdev.students.calculator.services.commands;

/**
 * Represents command, that finds mmin value of it`s arguments
 */
public class MinimumCommand implements Command {

    // command arguments
    Double[] arguments;

    public MinimumCommand(Double... args) {
        arguments = args;
    }

    /**
     * Execute command and return result
     *
     * @return result of calculations
     */
    @Override
    public double execute() {

        double min = arguments[0];
        for (double value : arguments) {
            if (value < min)
                min = value;
        }
        return min;
    }
}
