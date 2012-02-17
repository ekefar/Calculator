package com.teamdev.students.calculator.services.commands;

/**
 * Represents command, that finds square trunk of it`s first argument
 */
public class SquareTrunkCommand implements Command {

    // command arguments
    Double[] arguments;

    public SquareTrunkCommand(Double... args) {
        arguments = args;
    }

    /**
     * Execute command and return result
     *
     * @return result of calculations
     */
    @Override
    public double execute() {
        double arg = arguments[0];
        return Math.sqrt(arg);

    }
}
