package com.teamdev.students.calculator.services.commands;

import com.teamdev.students.calculator.model.Function;


/**
 * Represents command of evaluation of function or function
 */
public class EvaluateFunctionCommand implements Command {

    private Function function;
    private double[] arguments;

    public EvaluateFunctionCommand(Function function, double... args) {
        this.function = function;
        arguments = args;
    }

    @Override
    public double execute() {
        return function.evaluate(arguments);
    }
}
