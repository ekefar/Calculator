package com.teamdev.students.calculator.model;

/**
 * This class represents mathematical operation, such as +,-,*,/, etc.
 */
public class Operation extends Token {
    private String value;

    // operation`s precedence
    private int precedence;

    /**
     * get operation`s string representation
     *
     * @return operation`s string representation
     */
    public String getValue() {
        return value;
    }

    public Operation(String value) {
        this.value = value;
    }

    public Operation(String value, int precedence) {
        this.value = value;
        this.precedence = precedence;
    }

    /**
     * Set value of operation`s precedence
     *
     * @param precedence precedence value
     */
    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }

    /**
     * Get operation`s precedence.
     *
     * @return operation`s precedence
     */
    public int getPrecedence() {
        return precedence;
    }

    public String toString() {
        return value;
    }


}
