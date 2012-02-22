package com.teamdev.students.calculator.services.operations;


import com.teamdev.students.calculator.model.Operation;

/**
 * Created by IntelliJ IDEA.
 * Represents action of '^' operation of two double numbers
 */
class PowerOperation implements Operation {


    @Override
    public int getPrecedence() {
        return 3;
    }

    @Override
    public double evaluate(double... args) {
        double arg1 = args[0];
        double arg2 = args[1];

        return Math.pow(arg1, arg2);
    }
}
