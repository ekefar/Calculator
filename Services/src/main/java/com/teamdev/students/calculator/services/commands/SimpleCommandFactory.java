package com.teamdev.students.calculator.services.commands;

import com.teamdev.students.calculator.services.SimpleTokenFactory;


/**
 * Factory that creates Command objects.
 */
public class SimpleCommandFactory implements CommandFactory {


    @Override
    public Command createCommand(String commandType, Double... args) {
        if (commandType.equals(SimpleTokenFactory.Operations.PLUS.getValue()))
            return new PlusCommand(args);
        else if (commandType.equals(SimpleTokenFactory.Operations.MINUS.getValue()))
            return new MinusCommand(args);
        else if (commandType.equals(SimpleTokenFactory.Operations.MULTIPLICATION.getValue()))
            return new MultiplyCommand(args);
        else if (commandType.equals(SimpleTokenFactory.Operations.DIVISION.getValue()))
            return new DivisionCommand(args);
        else if (commandType.equals(SimpleTokenFactory.Operations.POWER.getValue()))
            return new PowerCommand(args);
        else if (commandType.equals(SimpleTokenFactory.Functions.MAX.getValue()))
            return new MaximumCommand(args);
        else if (commandType.equals(SimpleTokenFactory.Functions.MIN.getValue()))
            return new MinimumCommand(args);
        else if (commandType.equals(SimpleTokenFactory.Functions.SUM.getValue()))
            return new SumCommand(args);
        else if (commandType.equals(SimpleTokenFactory.Functions.SQRT.getValue()))
            return new SquareTrunkCommand(args);


        return null;
    }
}
