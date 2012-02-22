package com.teamdev.students.calculator.services.functions;

import com.teamdev.students.calculator.model.Function;
import com.teamdev.students.calculator.model.FunctionFactory;

/**
 * Represents function factory with base set of functions
 */
public class BaseFunctionFactory implements FunctionFactory {


    /**
     * Represents different math functions, such as max, min, etc.
     */
    public enum Functions {
        MAX("max"),
        MIN("min"),
        SQRT("sqrt"),
        SUM("sum");

        private String value;

        Functions(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Override
    public Function getFunction(String functionRepresentation) throws IllegalArgumentException {
        if (functionRepresentation.equals(Functions.MAX.getValue()))
            return new MaximumFunction();
        else if (functionRepresentation.equals(Functions.MIN.getValue()))
            return new MinimumFunction();
        else if (functionRepresentation.equals(Functions.SUM.getValue()))
            return new SumFunction();
        else if (functionRepresentation.equals(Functions.SQRT.getValue()))
            return new SquareTruncFunction();
        else {
            throw new IllegalArgumentException();
        }
    }

}
