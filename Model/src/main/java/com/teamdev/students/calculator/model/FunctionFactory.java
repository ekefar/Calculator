package com.teamdev.students.calculator.model;

import java.util.Set;

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
    Function createFunction(String functionRepresentation) throws IllegalArgumentException;

    /**
     * Get set of functions representations.
     *
     * @return
     */
    Set<String> getFunctionsRepresentations();
}
