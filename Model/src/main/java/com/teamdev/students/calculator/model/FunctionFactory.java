package com.teamdev.students.calculator.model;

/**
 * Represents factory for creating function objects.
 */
public interface FunctionFactory {

    /**
     * Get function object based on int`s string representation
     *
     * @param functionRepresentation function`s string representation
     * @return function object
     * @throws IllegalArgumentException if function was not found
     */
    public Function getFunction(String functionRepresentation) throws IllegalArgumentException;
}
