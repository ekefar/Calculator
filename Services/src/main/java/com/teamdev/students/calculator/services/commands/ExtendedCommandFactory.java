package com.teamdev.students.calculator.services.commands;

import com.teamdev.students.calculator.services.ExtendedTokenFactory;

/**
 * Factory that creates Command objects.
 */
public class ExtendedCommandFactory implements CommandFactory {

    @Override
    public Command createCommand(String commandType, Double... args) {
        if (commandType.equals(ExtendedTokenFactory.Operations.PLUS.getValue()))
            return new PlusCommand(args);
        else if (commandType.equals(ExtendedTokenFactory.Operations.MINUS.getValue()))
            return new MinusCommand(args);
        else if (commandType.equals(ExtendedTokenFactory.Operations.MULTIPLICATION.getValue()))
            return new MultiplyCommand(args);
        else if (commandType.equals(ExtendedTokenFactory.Operations.DIVISION.getValue()))
            return new DivisionCommand(args);
        else if (commandType.equals(ExtendedTokenFactory.Operations.POWER.getValue()))
            return new PowerCommand(args);
        else if (commandType.equals(ExtendedTokenFactory.Operations.MOD.getValue()))
            return new RemainderCommand(args);
        else if (commandType.equals(ExtendedTokenFactory.Functions.MAX.getValue()))
            return new MaximumCommand(args);
        else if (commandType.equals(ExtendedTokenFactory.Functions.MIN.getValue()))
            return new MinimumCommand(args);
        else if (commandType.equals(ExtendedTokenFactory.Functions.SUM.getValue()))
            return new SumCommand(args);
        else if (commandType.equals(ExtendedTokenFactory.Functions.SQRT.getValue()))
            return new SquareTrunkCommand(args);

        return null;
    }
}
