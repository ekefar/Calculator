package com.teamdev.students.calculator.services.operations;

import com.teamdev.students.calculator.model.Operation;
import com.teamdev.students.calculator.model.OperationFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Represent operation factory with base set of operations.
 */
public class BaseOperationFactory implements OperationFactory {
    /**
     * Represents different math operations, such as '+', '-', '*', etc.
     */
    private enum Operations {
        PLUS("+"),
        MINUS("-"),
        MULTIPLICATION("*"),
        DIVISION("/"),
        POWER("^");

        public String value;

        Operations(String value) {
            this.value = value;
        }

    }

    @Override
    public Operation createOperation(String operationRepresentation) throws IllegalArgumentException {

        if (Operations.PLUS.value.equals(operationRepresentation))
            return new PlusOperation();
        else if (Operations.MINUS.value.equals(operationRepresentation))
            return new MinusOperation();
        else if (Operations.DIVISION.value.equals(operationRepresentation))
            return new DivisionOperation();
        else if (Operations.MULTIPLICATION.value.equals(operationRepresentation))
            return new MultiplyOperation();
        else if (Operations.POWER.value.equals(operationRepresentation))
            return new PowerOperation();
        else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Set<String> getOperationsRepresentations() {

        Set<String> result = new HashSet<String>();

        for (Operations f : Operations.values()) {
            result.add(f.value);
        }

        return result;

    }
}
