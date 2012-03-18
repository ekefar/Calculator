package com.teamdev.students.calculator.services;

import com.teamdev.students.calculator.model.CalculatorObjectsProvider;
import com.teamdev.students.calculator.model.FunctionFactory;
import com.teamdev.students.calculator.model.Operation;
import com.teamdev.students.calculator.model.OperationFactory;
import com.teamdev.students.calculator.services.api.CalculationException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Represents object that contains info about calculation state.
 * It is encapsulate different aspects of mathematical expression
 * solving, such as currently handling part of expression, it`s
 * position, intermediate result of calculations and expression itself.
 */

public class CalculationContext {
    // expression to solve
    private String expression;

    // operands stack
    private Deque<Double> operands;

    // operations stack
    private Deque<Operation> operations;

    // position of currently solving part
    private int calculationIndex;

    // part of expression that handling right now
    private String currentToken;

    // current state
    private StateHandler currentState;

    // parent calculation context
    private CalculationContext parentContext;

    //object that provides info about functions and operations
    // used to solve expression
    private CalculatorObjectsProvider objectsProvider;

    private OperationFactory operationFactory;
    private FunctionFactory functionFactory;

    public CalculationContext(String expression, CalculatorObjectsProvider objectProvider) {
        this.expression = expression;
        this.objectsProvider = objectProvider;
        operands = new ArrayDeque<Double>();
        operations = new ArrayDeque<Operation>();
        operationFactory = objectsProvider.getOperationFactory();
        functionFactory = objectsProvider.getFunctionFactory();
        currentState = StateHandler.START;
    }


    public CalculationContext(CalculationContext parent) {
        this(parent.getExpression(), parent.getObjectsProvider());
        parentContext = parent;
        expression = parent.getExpression().substring(parent.getCalculationIndex() + 1);
    }


    public CalculatorObjectsProvider getObjectsProvider() {
        return objectsProvider;
    }

    public StateHandler getState() {
        return currentState;
    }

    public void setState(StateHandler currentState) {
        this.currentState = currentState;
    }

    public OperationFactory getOperationFactory() {
        return operationFactory;
    }

    public FunctionFactory getFunctionFactory() {
        return functionFactory;
    }

    public String getCurrentToken() {
        return currentToken;
    }

    public void setCurrentToken(String currentToken) {
        this.currentToken = currentToken;
    }

    public String getExpression() {
        return expression;
    }

    public int getCalculationIndex() {
        return calculationIndex;
    }

    public void setCalculationIndex(int calculationIndex) {
        this.calculationIndex = calculationIndex;
    }

    /**
     * Put operation into the operation stack.
     * If some data are ready for calculations then perform it.
     *
     * @param operation operation to place
     */
    public void handleOperation(Operation operation) {
        while (!operations.isEmpty() &&
                operation.getPrecedence() <= operations.peek().getPrecedence()) {
            calculateTemporaryData();
        }
        operations.push(operation);
    }

    /**
     * Convert number from it`s string value and push it into the operand stack
     *
     * @param operand operand to handle
     */
    public void handleOperand(Double operand) {
        operands.push(operand);
    }

    /**
     * Calculate part of parsed expression.
     */
    private void calculateTemporaryData() {
        double tempResult;
        double operand2 = operands.poll();
        double operand1 = operands.poll();
        tempResult = operations.poll().evaluate(operand1, operand2);
        operands.push(tempResult);
    }

    /**
     * Process all intermediate data and return result of calculations
     *
     * @return result of calculations
     */
    public Double getResult() {
        while (!operations.isEmpty())
            calculateTemporaryData();
        return operands.poll();
    }

    /**
     * Check balance of opening and closing brackets.
     *
     * @throws CalculationException if there are some extra opening or closing brackets
     */
    public void validateBrackets() throws CalculationException {
        // check for extra brackets
        if (parentContext != null)
            throw new CalculationException("Can't find proper closing bracket", findWrongOpeningBracket(expression));
        else if (calculationIndex < expression.length())
            throw new CalculationException(calculationIndex - 1);
    }

    /**
     * Find wrong placed opening bracket in the mathematical expression
     *
     * @param expression string with the expression
     * @return first wrong placed bracket position
     */
    private int findWrongOpeningBracket(String expression) {
        List<Integer> bracketIndexesList = new ArrayList<Integer>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(')
                bracketIndexesList.add(i);
            else if (expression.charAt(i) == ')')
                bracketIndexesList.remove(bracketIndexesList.size() - 1);
        }
        return bracketIndexesList.get(bracketIndexesList.size() - 1);
    }
}
