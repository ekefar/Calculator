package com.teamdev.students.calculator.services.commands;

import com.teamdev.students.calculator.model.Token;
import com.teamdev.students.calculator.services.ExtendedTokenFactory;

/**
 * Factory that creates Command objects.
 */
public class ExtendedCommandFactory implements CommandFactory {

    @Override
    public Command createCommand(Token commandType, Double... args) {
        String tokenValue = commandType.getValue();
        if (tokenValue.equals(ExtendedTokenFactory.Operations.PLUS.getValue()))
            return new PlusCommand(args);
        else if (tokenValue.equals(ExtendedTokenFactory.Operations.MINUS.getValue()))
            return new MinusCommand(args);
        else if (tokenValue.equals(ExtendedTokenFactory.Operations.MULTIPLICATION.getValue()))
            return new MultiplyCommand(args);
        else if (tokenValue.equals(ExtendedTokenFactory.Operations.DIVISION.getValue()))
            return new DivisionCommand(args);
        else if (tokenValue.equals(ExtendedTokenFactory.Operations.POWER.getValue()))
            return new PowerCommand(args);
        else if (tokenValue.equals(ExtendedTokenFactory.Operations.MOD.getValue()))
            return new RemainderCommand(args);
        else if (tokenValue.equals(ExtendedTokenFactory.Functions.MAX.getValue()))
            return new MaximumCommand(args);
        else if (tokenValue.equals(ExtendedTokenFactory.Functions.MIN.getValue()))
            return new MinimumCommand(args);
        else if (tokenValue.equals(ExtendedTokenFactory.Functions.SUM.getValue()))
            return new SumCommand(args);
        else if (tokenValue.equals(ExtendedTokenFactory.Functions.SQRT.getValue()))
            return new SquareTrunkCommand(args);

        return null;
    }
}
