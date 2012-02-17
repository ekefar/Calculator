package com.teamdev.students.calculator.model;

/**
 * Represents math function such as sin, cos, etc.
 */
public class Function extends Token {
    private String value;

    /**
     * Get function`s string representation
     *
     * @return function string representation
     */
    public String getValue() {
        return value;
    }


    public Function(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
