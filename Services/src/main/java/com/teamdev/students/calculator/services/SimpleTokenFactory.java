package com.teamdev.students.calculator.services;

import com.teamdev.students.calculator.model.Function;
import com.teamdev.students.calculator.model.Operation;
import com.teamdev.students.calculator.model.Token;
import com.teamdev.students.calculator.services.commands.CommandFactory;
import com.teamdev.students.calculator.services.commands.SimpleCommandFactory;

/**
 * Represents simple token factory with base operations
 */
public class SimpleTokenFactory implements TokenFactory {

    /**
     * Represents different math operations, such as '+', '-', '*', etc.
     */
    public enum Operations {
        PLUS("+", 1),
        MINUS("-", 1),
        MULTIPLICATION("*", 2),
        DIVISION("/", 2),
        POWER("^", 3);

        private String value;
        private int precedence;

        Operations(String value, int precedence) {
            this.value = value;
            this.precedence = precedence;
        }

        public String getValue() {
            return value;
        }

        public int getPrecedence() {
            return precedence;
        }


        public static Operations getOperation(String value) throws IllegalArgumentException {
            for (Operations operation : Operations.values()) {
                if (operation.getValue().equals(value))
                    return operation;
            }

            throw new IllegalArgumentException();
        }

        /**
         * check if enum contains such value
         *
         * @param value value to check
         * @return true if enum contains such value
         */
        public static boolean contains(String value) {
            for (Operations operation : Operations.values()) {
                if (operation.getValue().equals(value))
                    return true;
            }
            return false;
        }
    }


    /**
     * Represents different math functions, such as max, min, etc.
     */
    public enum Functions {
        MAX("max"),
        MIN("min"),
        SQRT("sqrt"),
        SUM("sum");


        private String value;

        Functions(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        /**
         * check if enum contains such value
         *
         * @param value value to check
         * @return true if enum contains such value
         */
        public static boolean contains(String value) {
            for (Functions function : Functions.values()) {
                if (function.getValue().equals(value))
                    return true;
            }
            return false;
        }
    }


    @Override
    public Token getToken(String value) throws IllegalArgumentException {

        if (Operations.contains(value)) {
            return new Operation(value, Operations.getOperation(value).getPrecedence());
        } else if (Functions.contains(value)) {
            return new Function(value);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public CommandFactory getCommandFactory() {
        return new SimpleCommandFactory();
    }
}
