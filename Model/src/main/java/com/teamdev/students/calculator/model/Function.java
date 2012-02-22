package com.teamdev.students.calculator.model;

/**
 * Represent functions such as max, min etc.
 */
public interface Function {

    /**
     * Calculate function`s value
     *
     * @param args function`s arguments
     * @return result of function calculation
     */
    public double evaluate(double... args);


}
