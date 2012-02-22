package com.teamdev.students.calculator.model;

/**
 * Represents calculation context...
 */
public interface CalculationContext {
    /**
     * Get function factory for this calculation context
     *
     * @return function factory object
     */
    public FunctionFactory getFunctionFactory();

    /**
     * Get operation factory for this calculation context
     *
     * @return function factory object
     */
    public OperationFactory getOperationFactory();
}
