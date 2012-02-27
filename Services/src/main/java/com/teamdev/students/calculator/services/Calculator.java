package com.teamdev.students.calculator.services;

import com.teamdev.students.calculator.parser.Parser;
import com.teamdev.students.calculator.parser.SimpleParser;


/**
 * Represents object that can perform solving of
 * correct mathematical expression.
 */
public class Calculator {

    CalculationContext context;

    // object that can parse parts of expression
    Parser parser;

    public Calculator(CalculationContext context) {
        this.context = context;
        parser = new SimpleParser(context.getExpression());
    }

    /**
     * Parse expression and calculate the result.
     *
     * @return result of calculations
     * @throws CalculationException if expression is syntactically incorrect
     */
    public Double run() throws CalculationException {
        try {
            while (parser.hasNext() &&
                    context.getState() != StateHandler.DELIMITER &&
                    context.getState() != StateHandler.CLOSING_BRACKET) {

                // parse part of expression and store in in calc context
                context.setCurrentToken(parser.parseNext());

                // then handle change of context
                StateHandler.handleState(context);

                // This method can be invoked recursively, and parsing index
                // can be changed elsewhere and stored in calculation context.
                // So, after recursive invocation we should change current parsing
                // index according to context.
                if (parser.getParsingPosition() > context.getCalculationIndex()) {
                    // store parsing position in context
                    context.setCalculationIndex(parser.getParsingPosition());
                } else {

                    // get parsing position from context (if recursive invocation occur)
                    parser.setParsingPosition(context.getCalculationIndex());
                }
            }
            // check if expression have been parsed entirely
            checkFinish();
        } catch (Exception e) {
            if (context.getCalculationIndex() >= context.getExpression().length() - 1) {
                throw new IllegalArgumentException("Unexpected end of expression");
            } else {
                throw new CalculationException(context.getCalculationIndex());
            }
        }

        // return result
        return context.getResult();
    }

    /**
     * Check if expression have been parsed entirely and there are no syntactical mistakes.
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if parsing have been interrupted
     *          before expression end
     */
    private void checkFinish() throws CalculationException {
        if (!parser.hasNext() && !context.getCurrentToken().equals(")")) {
            StateHandler.handleState(context);
        }
    }

}
