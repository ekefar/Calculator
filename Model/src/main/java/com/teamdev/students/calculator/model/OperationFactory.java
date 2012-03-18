package com.teamdev.students.calculator.model;


import java.util.Set;

/**
 * Represents factory for creating operation objects.
 */
public interface OperationFactory {

    /**
     * Get operation object based on int`s string representation
     *
     * @param operationRepresentation operation`s string representation
     * @return operation object
     * @throws IllegalArgumentException if operation was not found
     */
    Operation createOperation(String operationRepresentation) throws IllegalArgumentException;

    /**
     * Get array of operations representations;
     *
     * @return
     */
    Set<String> getOperationsRepresentations();
}
