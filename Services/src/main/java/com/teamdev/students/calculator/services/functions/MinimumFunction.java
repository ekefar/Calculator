package com.teamdev.students.calculator.services.functions;


import com.teamdev.students.calculator.model.Function;

/**
 * Created by IntelliJ IDEA.
 * Function that can find max value among it`s arguments
 */
class MinimumFunction implements Function {

    @Override
    public double evaluate(double... args) {
        double min = args[0];
        for (double value : args) {
            if (value < min)
                min = value;
        }
        return min;
    }
}
