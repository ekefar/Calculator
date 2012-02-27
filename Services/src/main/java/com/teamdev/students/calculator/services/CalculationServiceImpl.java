package com.teamdev.students.calculator.services;

import com.teamdev.students.calculator.model.CalculatorObjectsProvider;

/**
 * Implementation of CalculationService that can provide calculation of math expression
 */
class CalculationServiceImpl implements CalculationService {


    CalculatorObjectsProvider objectsProvider;

    public CalculationServiceImpl(CalculatorObjectsProvider objectsProvider) {
        setup();
        this.objectsProvider = objectsProvider;
    }

    public CalculationServiceImpl() {
        objectsProvider = new BaseCalculatorObjectProvider();
        setup();
    }

    @Override
    public double calculate(String expression) throws CalculationException {

        if (expression == null)
            throw new NullPointerException("Nothing to calculate.");

        expression = expression.replaceAll(" ", "");
        if (expression.equals(""))
            throw new IllegalArgumentException("Nothing to calculate.");

        CalculationContext context = new CalculationContext(expression, objectsProvider);
        // parse string expression
        double result = new Calculator(context).run();

        context.validateBrackets();
        return result;

    }

    /**
     * make some initial settings
     */
    private void setup() {
    }


}
