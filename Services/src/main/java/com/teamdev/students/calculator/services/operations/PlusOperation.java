package com.teamdev.students.calculator.services.operations;


import com.teamdev.students.calculator.model.Operation;

/**
 * Created by IntelliJ IDEA.
 * Represents action of '+' operation of two double numbers
 */
class PlusOperation implements Operation {


    @Override
    public int getPrecedence() {
        return 1;
    }

    @Override
    public double evaluate(double... args) {
        double arg1 = args[0];
        double arg2 = args[1];

        return arg1 + arg2;
    }
}
