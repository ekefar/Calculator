package com.teamdev.students.calculator.services;

import com.teamdev.students.calculator.model.CalculatorObjectsProvider;
import com.teamdev.students.calculator.services.api.CalculationException;
import com.teamdev.students.calculator.services.api.CalculationService;

/**
 * Implementation of CalculationService that can provide calculation of math expression
 */
class CalculationServiceImpl implements CalculationService {


    CalculatorObjectsProvider objectsProvider;

    public CalculationServiceImpl(CalculatorObjectsProvider objectsProvider) {
        this.objectsProvider = objectsProvider;
    }

    public CalculationServiceImpl() {
        objectsProvider = new BaseCalculatorObjectProvider();
    }

    @Override
    public double calculate(String expression) throws CalculationException {

        if (expression == null)
            throw new NullPointerException("Nothing to calculate.");

        if (expression.equals(""))
            throw new IllegalArgumentException("Nothing to calculate.");

        CalculationContext context = new CalculationContext(expression, objectsProvider);
        // parse string expression
        double result = new Calculator(context).run();

        context.validateBrackets();
        return result;

    }


}
