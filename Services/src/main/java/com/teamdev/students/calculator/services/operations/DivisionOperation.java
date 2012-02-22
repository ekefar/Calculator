package com.teamdev.students.calculator.services.operations;


import com.teamdev.students.calculator.model.Operation;

/**
 * Created by IntelliJ IDEA.
 * Represents action of '/' operation of two double numbers
 */
class DivisionOperation implements Operation {


    @Override
    public int getPrecedence() {
        return 2;
    }

    @Override
    public double evaluate(double... args) {
        double arg1 = args[0];
        double arg2 = args[1];

        if (arg2 == 0.0)
            throw new ArithmeticException("Division by zero.");

        return arg1 / arg2;
    }
}
