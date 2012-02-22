package com.teamdev.students.calculator.model;


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
    public Operation getOperation(String operationRepresentation) throws IllegalArgumentException;
}
