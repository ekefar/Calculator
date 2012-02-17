package com.teamdev.students.calculator.services;

/**
 * Represents service, that can perform calculation of mathematical expression
 */
public interface CalculationService {

    /**
     * Calculate mathematical expression.
     *
     * @param expression expression to solve
     * @return result of calculation
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          If expression is syntactically incorrect
     *          or some other calculation error occurs
     */
    double calculate(String expression) throws CalculationException;
}
