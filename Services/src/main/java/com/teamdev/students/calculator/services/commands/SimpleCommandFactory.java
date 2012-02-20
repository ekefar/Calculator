package com.teamdev.students.calculator.services.commands;

import com.teamdev.students.calculator.model.Token;
import com.teamdev.students.calculator.services.SimpleTokenFactory;


/**
 * Factory that creates Command objects.
 */
public class SimpleCommandFactory implements CommandFactory {


    @Override
    public Command createCommand(Token commandType, Double... args) {
        String tokenValue = commandType.getValue();
        if (tokenValue.equals(SimpleTokenFactory.Operations.PLUS.getValue()))
            return new PlusCommand(args);
        else if (tokenValue.equals(SimpleTokenFactory.Operations.MINUS.getValue()))
            return new MinusCommand(args);
        else if (tokenValue.equals(SimpleTokenFactory.Operations.MULTIPLICATION.getValue()))
            return new MultiplyCommand(args);
        else if (tokenValue.equals(SimpleTokenFactory.Operations.DIVISION.getValue()))
            return new DivisionCommand(args);
        else if (tokenValue.equals(SimpleTokenFactory.Operations.POWER.getValue()))
            return new PowerCommand(args);
        else if (tokenValue.equals(SimpleTokenFactory.Functions.MAX.getValue()))
            return new MaximumCommand(args);
        else if (tokenValue.equals(SimpleTokenFactory.Functions.MIN.getValue()))
            return new MinimumCommand(args);
        else if (tokenValue.equals(SimpleTokenFactory.Functions.SUM.getValue()))
            return new SumCommand(args);
        else if (tokenValue.equals(SimpleTokenFactory.Functions.SQRT.getValue()))
            return new SquareTrunkCommand(args);


        return null;
    }
}
