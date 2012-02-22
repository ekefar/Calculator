package com.teamdev.students.calculator.services.operations;

import com.teamdev.students.calculator.model.Operation;
import com.teamdev.students.calculator.model.OperationFactory;

/**
 * Represent operation factory with base set of operations.
 */
public class BaseOperationFactory implements OperationFactory {
    /**
     * Represents different math operations, such as '+', '-', '*', etc.
     */
    public enum Operations {
        PLUS("+"),
        MINUS("-"),
        MULTIPLICATION("*"),
        DIVISION("/"),
        POWER("^");

        private String value;

        Operations(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    @Override
    public Operation getOperation(String operationRepresentation) throws IllegalArgumentException {

        if (operationRepresentation.equals(Operations.PLUS.getValue()))
            return new PlusOperation();
        else if (operationRepresentation.equals(Operations.MINUS.getValue()))
            return new MinusOperation();
        else if (operationRepresentation.equals(Operations.DIVISION.getValue()))
            return new DivisionOperation();
        else if (operationRepresentation.equals(Operations.MULTIPLICATION.getValue()))
            return new MultiplyOperation();
        else if (operationRepresentation.equals(Operations.POWER.getValue()))
            return new PowerOperation();
        else {
            throw new IllegalArgumentException();
        }
    }
}
