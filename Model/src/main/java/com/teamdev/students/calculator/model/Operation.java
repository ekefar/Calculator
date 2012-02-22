package com.teamdev.students.calculator.model;

/**
 * This class represents mathematical operation, such as +,-,*,/, etc.
 */
public interface Operation {


    /**
     * Get operation`s precedence.
     *
     * @return operation`s precedence
     */
    public int getPrecedence();

    /**
     * calculate result of operation`s execution
     *
     * @param args arguments
     * @return result of execution
     */
    public double evaluate(double... args);


}
