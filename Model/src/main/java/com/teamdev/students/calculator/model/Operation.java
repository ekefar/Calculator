package com.teamdev.students.calculator.model;

/**
 * This class represents mathematical operation, such as +,-,*,/, etc.
 */
public class Operation extends Token {
    private String value;

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


    /**
     * Get operation`s precedence.
     * '+', '-' - precedence 1;
     * '/', '/' - precedence 2;
     * '^' - precedence 3;
     *
     * @return operation`s precedence
     */
    public byte getPrecedence() {
        if (value.equals("+") || value.equals("-"))
            return 1;
        if (value.equals("*") || value.equals("/"))
            return 2;

        else return 3;
    }

    public String toString() {
        return value;
    }


}
