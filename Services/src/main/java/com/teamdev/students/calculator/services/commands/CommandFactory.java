package com.teamdev.students.calculator.services.commands;

import com.teamdev.students.calculator.services.TokenFactory;


/**
 * Factory that creates Command objects.
 */
public class CommandFactory {


    /**
     * Create new command.
     *
     * @param commandType Type of command
     * @param args        command arguments
     * @return Command object or null if command type is invalid
     */
    public static Command createCommand(String commandType, Double... args) {
        if (commandType.equals(TokenFactory.Operations.PLUS.getValue()))
            return new PlusCommand(args);
        else if (commandType.equals(TokenFactory.Operations.MINUS.getValue()))
            return new MinusCommand(args);
        else if (commandType.equals(TokenFactory.Operations.MULTIPLICATION.getValue()))
            return new MultiplyCommand(args);
        else if (commandType.equals(TokenFactory.Operations.DIVISION.getValue()))
            return new DivisionCommand(args);
        else if (commandType.equals(TokenFactory.Operations.POWER.getValue()))
            return new PowerCommand(args);
        else if (commandType.equals(TokenFactory.Functions.MAX.getValue()))
            return new MaximumCommand(args);
        else if (commandType.equals(TokenFactory.Functions.MIN.getValue()))
            return new MinimumCommand(args);
        else if (commandType.equals(TokenFactory.Functions.SUM.getValue()))
            return new SumCommand(args);
        else if (commandType.equals(TokenFactory.Functions.SQRT.getValue()))
            return new SquareTrunkCommand(args);


        return null;
    }
}
