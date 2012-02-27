package com.teamdev.students.calculator.services;

import com.teamdev.students.calculator.model.CalculatorObjectsProvider;
import com.teamdev.students.calculator.model.FunctionFactory;
import com.teamdev.students.calculator.model.OperationFactory;
import com.teamdev.students.calculator.services.functions.BaseFunctionFactory;
import com.teamdev.students.calculator.services.operations.BaseOperationFactory;

/**
 * Represents calculator object provider that contains base set of objects
 */
public class BaseCalculatorObjectProvider implements CalculatorObjectsProvider {
    @Override
    public FunctionFactory getFunctionFactory() {
        return new BaseFunctionFactory();
    }

    @Override
    public OperationFactory getOperationFactory() {
        return new BaseOperationFactory();
    }
}
