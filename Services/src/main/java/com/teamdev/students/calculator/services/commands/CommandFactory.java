package com.teamdev.students.calculator.services.commands;

import com.teamdev.students.calculator.model.Token;

/**
 * Factory that creates Command objects.
 */
public interface CommandFactory {

    /**
     * Create new command.
     *
     * @param commandType Operation or function that used for choosing command type
     * @param args        command arguments
     * @return Command object or null if command type is invalid
     */
    public Command createCommand(Token commandType, Double... args);
}
