package com.teamdev.students.calculator.parser;

import com.teamdev.students.calculator.model.CalculatorObjectsProvider;
import com.teamdev.students.calculator.model.FunctionFactory;
import com.teamdev.students.calculator.model.OperationFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Simple implementation of Parser interface.
 * Can extract numbers, alphabetic sequences or single characters.
 */
public class SimpleParser implements Parser {

    private final char OPENING_BRACKET = '(';
    private final char ARGUMENTS_DELIMITER = ',';

    // currently parsing position
    private int parsingPosition;

    // expression to parse
    private String expression;
    private FunctionFactory functionFactory;
    private OperationFactory operationFactory;


    public SimpleParser(CalculatorObjectsProvider objectsProvider) {
        functionFactory = objectsProvider.getFunctionFactory();
        operationFactory = objectsProvider.getOperationFactory();
    }

    public SimpleParser(CalculatorObjectsProvider objectsProvider, String expression) {
        this(objectsProvider);
        this.expression = expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }


    @Override
    public boolean hasNext() {
        return (parsingPosition <= expression.length() - 1);
    }

    @Override
    public int getParsingPosition() {
        return parsingPosition;
    }

    @Override
    public void setParsingPosition(int parsingPosition) {
        this.parsingPosition = parsingPosition;
    }

    @Override
    public String parseNext() throws IllegalArgumentException {

        skipWhitespaces();

        if (!hasNext())
            return null;

        return extractToken();
    }

    /**
     * Skip whitespaces
     */
    private void skipWhitespaces() {
        while (expression.charAt(parsingPosition) == ' ')
            parsingPosition++;
    }


    /**
     * extract recognized token from string
     *
     * @return extracted token
     */
    private String extractToken() {
        char currentChar = expression.charAt(parsingPosition);

        // try to extract number
        String tokenValue = extractNumber();
        // if failed then try to extract defined calculation token
        if (tokenValue.equals("")) {
            tokenValue = extractCalculationToken();
        }
        // if failed then return this character
        if (tokenValue.equals("")) {
            parsingPosition++;
            tokenValue = Character.toString(currentChar);
        }
        return tokenValue;
    }


    /**
     * Extract number from given string expression that starts from current parsing position.
     *
     * @return extracted number
     * @throws NumberFormatException if character sequence is not valid number
     */
    private String extractNumber() throws IllegalArgumentException {

        String extractedNumber = "";

        // try to extract negative number
        if (expression.charAt(parsingPosition) == '-')
            if ((parsingPosition == 0 ||
                    (parsingPosition > 0 && (expression.charAt(parsingPosition - 1) == OPENING_BRACKET ||
                            expression.charAt(parsingPosition - 1) == ARGUMENTS_DELIMITER))) &&
                    Character.isDigit(expression.charAt(parsingPosition + 1))) {
                extractedNumber += "-";
                parsingPosition++;
            }

        while (parsingPosition < expression.length()) {
            if (Character.isDigit(expression.charAt(parsingPosition)) || expression.charAt(parsingPosition) == '.') {
                if (expression.charAt(parsingPosition) == '.' && parsingPosition != expression.length() - 1 &&
                        !Character.isDigit(expression.charAt(parsingPosition + 1)))
                    throw new IllegalArgumentException();
                extractedNumber += expression.charAt(parsingPosition);
                parsingPosition++;
            } else {
                break;
            }
        }

        return extractedNumber;
    }

    /**
     * Extract function from given string expression that starts from given position.
     *
     * @return extracted number
     */
    private String extractCalculationToken() {

        String extractedToken = "";
        Set<String> tokens = functionFactory.getFunctionsRepresentations();
        tokens.addAll(operationFactory.getOperationsRepresentations());

        while (parsingPosition < expression.length()) {
            Set<String> matchTokens = new HashSet<String>();
            extractedToken += expression.charAt(parsingPosition++);

            // find match among known functions
            for (String tokenValue : tokens) {
                if (tokenValue.startsWith(extractedToken)) {
                    matchTokens.add(tokenValue);
                }
            }

            tokens = matchTokens;

            // if no match then rollback parsing index and return
            if (tokens.size() == 0) {
                parsingPosition--;
                return "";
            }

            // if entire match found then stop searching
            if (tokens.contains(extractedToken))
                break;
        }

        return extractedToken;
    }


}
