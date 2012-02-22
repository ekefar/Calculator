package com.teamdev.students.calculator.services.functions;


import com.teamdev.students.calculator.model.Function;

/**
 * Created by IntelliJ IDEA.
 * Function that can find square trunk of first argument
 */
class SquareTruncFunction implements Function {


    @Override
    public double evaluate(double... args) {

        double arg = args[0];
        return Math.sqrt(arg);
    }
}
