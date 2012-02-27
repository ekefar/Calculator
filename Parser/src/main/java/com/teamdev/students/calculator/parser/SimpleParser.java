package com.teamdev.students.calculator.parser;

/**
 * Simple implementation of Parser interface.
 * Can extract numbers, alphabetic sequences or single characters.
 */
public class SimpleParser implements Parser {
    // currently parsing position
    private int parsingPosition;

    // expression to parse
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public SimpleParser() {

    }

    public SimpleParser(String expression) {
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
        if (!hasNext())
            return null;

        return extractToken();
    }

    /**
     * extract recognized token from string
     *
     * @return extracted token
     */
    private String extractToken() {
        char currentChar = expression.charAt(parsingPosition);

        // if character is digit, then try to extract whole number
        if (Character.isDigit(currentChar)) {
            return extractNumber();
        }
        // if character is alphabetic then try to create function token
        else if (Character.isAlphabetic(currentChar)) {
            return extractFunction();
        }
        // '-' character  - try to extract negative number
        else if (currentChar == '-') {
            String tokenValue = extractNumber();
            if (!tokenValue.equals("")) {
                return tokenValue;
            } else {
                parsingPosition++;
                return "-";
            }
        } else {
            parsingPosition++;
            return Character.toString(currentChar);
        }
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
            if (parsingPosition == 0 ||
                    (parsingPosition > 0 && (expression.charAt(parsingPosition - 1) == '(' || expression.charAt(parsingPosition - 1) == ','))) {
                extractedNumber += "-";
                parsingPosition++;
            }

        while (parsingPosition < expression.length()) {
            if (Character.isDigit(expression.charAt(parsingPosition)) || expression.charAt(parsingPosition) == '.') {
                if (expression.charAt(parsingPosition) == '.' && parsingPosition != expression.length() - 1 && !Character.isDigit(expression.charAt(parsingPosition + 1)))
                    throw new IllegalArgumentException();
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


}
