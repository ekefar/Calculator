package com.teamdev.students.calculator.services.functions;


import com.teamdev.students.calculator.model.Function;

/**
 * Created by IntelliJ IDEA.
 * Function that can find minimum value among it`s arguments
 */
class MaximumFunction implements Function {


    @Override
    public double evaluate(double... args) {
        double max = args[0];
        for (double value : args) {
            if (value > max)
                max = value;
        }
        return max;
    }
}
