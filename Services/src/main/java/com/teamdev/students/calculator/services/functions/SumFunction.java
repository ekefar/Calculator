package com.teamdev.students.calculator.services.functions;


import com.teamdev.students.calculator.model.Function;

/**
 * Created by IntelliJ IDEA.
 * Function that can find sum of it`s arguments
 */
class SumFunction implements Function {


    @Override
    public double evaluate(double... args) {

        double result = 0.0;
        for (double value : args) {
            result += value;
        }
        return result;
    }
}
