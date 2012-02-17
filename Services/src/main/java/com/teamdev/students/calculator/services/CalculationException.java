package com.teamdev.students.calculator.services;

/**
 * Represents exception that occurs during calculation of the mathematical expression.
 */
public class CalculationException extends Exception {


    // position of invalid character
    private int invalidTokenPosition;

    public CalculationException(String message) {
        super(message);
    }

    /**
     * Return position of the invalid character in the expression
     *
     * @return position of the invalid character
     */
    public int getInvalidTokenPosition() {
        return invalidTokenPosition;
    }

    public CalculationException(int invalidTokenPosition) {
        super("Invalid token");

        this.invalidTokenPosition = invalidTokenPosition;
    }

    public CalculationException(String message, int errorPosition) {
        super(message);
        invalidTokenPosition = errorPosition;
    }
}
