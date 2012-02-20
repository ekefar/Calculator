package com.teamdev.students.calculator.services;

import com.teamdev.students.calculator.model.Function;
import com.teamdev.students.calculator.model.Operation;
import com.teamdev.students.calculator.services.commands.CommandFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Implementation of CalculationService that can provide calculation of math expression
 */
public class CalculationServiceImpl implements CalculationService {
    // currently parsing token position
    private int parsingPosition;

    // object that handles state changing depending on currently parsing token
    private StateHandler stateHandler;

    // bracket counter. When expression have been parsed entirely it should be equal 0
    private int bracketCount;

    // expression to parse
    private String expression;

    // factory that can create tokens from string expression
    TokenFactory tokenFactory;

    CommandFactory commandFactory;

    public CalculationServiceImpl(TokenFactory tokenFactory) {
        setup();
        this.tokenFactory = tokenFactory;
        this.commandFactory = tokenFactory.getCommandFactory();
    }


    @Override
    public double calculate(String expression) throws CalculationException {
        this.expression = expression;

        if (expression == null)
            throw new NullPointerException("Nothing to calculate.");

        expression = expression.replaceAll(" ", "");
        if (expression.equals(""))
            throw new IllegalArgumentException("Nothing to calculate.");


        // parse string expression
        double result = resolveExpression();

        // check for extra brackets
        if (bracketCount > 0)
            throw new CalculationException("Can't find proper closing bracket", findWrongOpeningBracket(expression));
        else if (bracketCount < 0 || parsingPosition < expression.length())
            throw new CalculationException(parsingPosition);

        return result;
    }

    public CalculationServiceImpl() {
        setup();
        tokenFactory = new SimpleTokenFactory();
        commandFactory = tokenFactory.getCommandFactory();
    }


    private void setup() {
        parsingPosition = 0;
        bracketCount = 0;
        stateHandler = new StateHandler();
    }

    /**
     * Parse part of string expression to token list, and get result of
     * calculations.
     *
     * @return list of Token objects ordered according to reverse
     *         polish notation
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if parsing error occurred
     */
    public double resolveExpression() throws CalculationException {
        // stack with operands (numbers)
        Deque<Double> operands = new ArrayDeque<Double>();

        // stack with operations (*,/,etc.)
        Deque<Operation> operations = new ArrayDeque<Operation>();

        while (parsingPosition < expression.length()) {
            Character currentChar = expression.charAt(parsingPosition);
            try {
                if (currentChar == ')') {
                    stateHandler.handleClosingBracket();
                    bracketCount--;
                    break;
                } else if (currentChar == ',') {
                    stateHandler.handleDelimiter();
                    break;
                } else if (currentChar == '(') {
                    stateHandler.handleOpeningBracket();
                    bracketCount++;
                    parsingPosition++;
                    operands.push(resolveExpression());
                } else {
                    handleExpression(operands, operations);
                }
            } catch (IllegalArgumentException e) {
                throw new CalculationException(parsingPosition);
            }
            parsingPosition++;
        }
        checkFinish();
        while (!operations.isEmpty())
            calculateTemporaryData(operations, operands);
        return operands.poll();
    }

    /**
     * Check if expression have been parsed entirely and there are no syntactical mistakes.
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if parsing have been interrupted
     *          before expression end
     */
    private void checkFinish() throws CalculationException {
        try {
            if (parsingPosition == expression.length()) {
                stateHandler.handleFinish();
            }
        } catch (Exception e) {
            parsingPosition--;
            throw new CalculationException(parsingPosition);
        }
    }

    /**
     * Put operation into the operation stack.
     * If some data are ready for calculations then perform it.
     *
     * @param operands       stack of operands
     * @param operations     stack of operations
     * @param operationValue operation to place
     * @throws CalculationException if unknown operation value
     */
    private void handleOperation(String operationValue, Deque<Double> operands, Deque<Operation> operations) throws CalculationException {
        try {
            Operation operation = (Operation) tokenFactory.getToken(operationValue);
            stateHandler.handleOperation();
            while (!operations.isEmpty() &&
                    operation.getPrecedence() <= operations.peek().getPrecedence()) {
                calculateTemporaryData(operations, operands);
            }
            operations.push(operation);
        } catch (IllegalArgumentException e) {
            throw new CalculationException(parsingPosition);
        }
    }

    /**
     * Calculate part of parsed expression.
     *
     * @param operations stack of operations
     * @param operands   stack of operands
     */
    private void calculateTemporaryData(Deque<Operation> operations, Deque<Double> operands) {
        double tempResult;
        if (!operations.isEmpty()) {
            double operand2 = operands.poll();
            double operand1 = operands.poll();
            tempResult = commandFactory.createCommand(operations.poll().toString(), operand1, operand2).execute();
            operands.push(tempResult);
        }
    }


    /**
     * Extract closest to the current parsing position token and handle it.
     *
     * @param operands   Stack of operands. If during execution of this method
     *                   some number extracted, it will be added into this stack.
     * @param operations Stack of operations. If during execution of this method
     *                   some operation extracted, it will be added into this stack.
     * @throws CalculationException if any errors occur.
     */
    private void handleExpression(Deque<Double> operands, Deque<Operation> operations)
            throws CalculationException {
        char currentChar = expression.charAt(parsingPosition);

        // if character is digit, then try to extract whole number
        if (Character.isDigit(currentChar)) {
            handleNumber(extractNumber(), operands);
        }
        // if character is alphabetic then try to create function token
        else if (Character.isAlphabetic(currentChar)) {
            handleFunction(extractFunction(), operands);
        }
        // '-' character  - try to extract negative number
        else if (currentChar == '-') {
            String tokenValue = extractNumber();
            if (!tokenValue.equals("")) {
                handleNumber(tokenValue, operands);
            } else {
                handleOperation(Character.toString(currentChar), operands, operations);
            }
        } else {
            handleOperation(Character.toString(currentChar), operands, operations);
        }

    }

    /**
     * Create function, solve it and push it value into the operand stack
     *
     * @param functionName function`s name
     * @param operands     operand stack
     * @throws CalculationException if any error occur
     */
    private void handleFunction(String functionName, Deque<Double> operands) throws CalculationException {
        try {
            Function function = (Function) tokenFactory.getToken(functionName);
            stateHandler.handleFunction();
            operands.push(solveFunction(function));
        } catch (IllegalArgumentException e) {
            throw new CalculationException("Unknown function", parsingPosition - functionName.length());
        }
    }

    /**
     * Convert number from it`s string value and push it into the operand stack
     *
     * @param numberValue String value of number
     * @param operands    operand stack
     * @throws CalculationException if sny error occur
     */
    private void handleNumber(String numberValue, Deque<Double> operands) throws CalculationException {
        try {
            double number = Double.valueOf(numberValue);
            stateHandler.handleNumber();
            parsingPosition--;
            operands.push(number);
        } catch (NumberFormatException e) {
            throw new CalculationException(parsingPosition - 1);
        } catch (IllegalArgumentException e) {
            throw new CalculationException(parsingPosition - numberValue.length());
        }
    }


    /**
     * Extract number from given string expression that starts from current parsing position.
     *
     * @return extracted number
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if character sequence is not valid number
     */
    private String extractNumber() throws CalculationException {

        String extractedNumber = "";

        // try to extract negative number
        if (expression.charAt(parsingPosition) == '-')
            if (parsingPosition == 0 ||
                    (parsingPosition > 0 && (expression.charAt(parsingPosition - 1) == '(' || expression.charAt(parsingPosition - 1) == ','))) {
                extractedNumber += "-";
                parsingPosition++;
            }

        while (parsingPosition < expression.length()) {
            if (Character.isDigit(expression.charAt(parsingPosition)) || expression.charAt(parsingPosition) == '.') {
                if (expression.charAt(parsingPosition) == '.' && parsingPosition != expression.length() - 1 && !Character.isDigit(expression.charAt(parsingPosition + 1)))
                    throw new CalculationException(parsingPosition);
                extractedNumber += Character.toString(expression.charAt(parsingPosition));
                parsingPosition++;
            } else {
                break;
            }
        }

        return extractedNumber;
    }

    /**
     * Extract alphabetic sequence from given string expression that starts from given position.
     *
     * @return extracted number
     */
    private String extractFunction() {

        String extractedFunction = "";
        while (parsingPosition < expression.length()) {
            if (Character.isAlphabetic(expression.charAt(parsingPosition))) {
                extractedFunction += Character.toString(expression.charAt(parsingPosition));
                parsingPosition++;
            } else {
                break;
            }
        }
        return extractedFunction;
    }

    /**
     * Get function`s value
     *
     * @param function function to execute
     * @return value of function
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if there was an error during function execution
     */
    private double solveFunction(Function function) throws CalculationException {
        // check opening bracket right after function name
        if (expression.charAt(parsingPosition) == '(') {
            bracketCount++;
            stateHandler.handleOpeningBracket();
        } else
            throw new CalculationException(parsingPosition);

        // list of function arguments
        List<Double> arguments = new ArrayList<Double>();

        // extract function arguments
        while (parsingPosition < expression.length() - 1 && expression.charAt(parsingPosition) != ')') {
            parsingPosition++;
            arguments.add(resolveExpression());
        }

        // create proper command, execute it and return result of execution
        return commandFactory.createCommand(function.getValue(), arguments.toArray(new Double[arguments.size()])).execute();
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
