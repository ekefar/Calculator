package com.teamdev.students.calculator.services.commands;

import com.teamdev.students.calculator.model.Operation;

/**
 * Represents command of evaluation of function or operation
 */
public class EvaluateOperationCommand implements Command {

    private Operation operation;
    private double[] arguments;

    public EvaluateOperationCommand(Operation operation, double... args) {
        this.operation = operation;
        arguments = args;
    }

    @Override
    public double execute() {
        return operation.evaluate(arguments);
    }
}
