package com.teamdev.students.calculator.services;

import com.teamdev.students.calculator.model.CalculatorObjectsProvider;
import com.teamdev.students.calculator.model.FunctionFactory;
import com.teamdev.students.calculator.model.OperationFactory;
import com.teamdev.students.calculator.services.functions.FunctionFactoryImpl;
import com.teamdev.students.calculator.services.operations.OperationFactoryImpl;

/**
 * Represents calculator object provider that contains base set of objects
 */
public class CalculatorObjectProviderImpl implements CalculatorObjectsProvider {
    @Override
    public FunctionFactory getFunctionFactory() {
        return new FunctionFactoryImpl();
    }

    @Override
    public OperationFactory getOperationFactory() {
        return new OperationFactoryImpl();
    }
}
