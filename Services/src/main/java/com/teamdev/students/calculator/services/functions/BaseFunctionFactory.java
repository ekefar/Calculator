package com.teamdev.students.calculator.services.functions;

import com.teamdev.students.calculator.model.Function;
import com.teamdev.students.calculator.model.FunctionFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents function factory with base set of functions
 */
public class BaseFunctionFactory implements FunctionFactory {


    /**
     * Represents different math functions, such as max, min, etc.
     */
    private enum Functions {
        MAX("max"),
        MIN("min"),
        SQRT("sqrt"),
        SUM("sum");

        public String value;

        Functions(String value) {
            this.value = value;
        }
    }

    @Override
    public Function createFunction(String functionRepresentation) throws IllegalArgumentException {
        if (Functions.MAX.value.equals(functionRepresentation))
            return new MaximumFunction();
        else if (Functions.MIN.value.equals(functionRepresentation))
            return new MinimumFunction();
        else if (Functions.SUM.value.equals(functionRepresentation))
            return new SumFunction();
        else if (Functions.SQRT.value.equals(functionRepresentation))
            return new SquareTruncFunction();
        else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Set<String> getFunctionsRepresentations() {
        Set<String> result = new HashSet<String>();

        for (Functions f : Functions.values()) {
            result.add(f.value);
        }

        return result;
    }

}
