package com.teamdev.students.calculator.services.commands;

/**
 * Represents command, that finds max value of it`s arguments
 */
public class MaximumCommand implements Command {

    // command arguments
    Double[] arguments;

    public MaximumCommand(Double... args) {
        arguments = args;
    }

    /**
     * Execute command and return result
     *
     * @return result of calculations
     */
    @Override
    public double execute() {
        double max = arguments[0];
        for (double value : arguments) {
            if (value > max)
                max = value;
        }
        return max;
    }
}
