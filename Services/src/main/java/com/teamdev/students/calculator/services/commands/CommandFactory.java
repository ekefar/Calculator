package com.teamdev.students.calculator.services.commands;

/**
 * Factory that creates Command objects.
 */
public interface CommandFactory {

    /**
     * Create new command.
     *
     * @param commandType Type of command
     * @param args        command arguments
     * @return Command object or null if command type is invalid
     */
    public Command createCommand(String commandType, Double... args);
}
