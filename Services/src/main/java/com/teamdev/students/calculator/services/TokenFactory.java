package com.teamdev.students.calculator.services;

import com.teamdev.students.calculator.model.Function;
import com.teamdev.students.calculator.model.Operation;
import com.teamdev.students.calculator.model.Token;

/**
 * Factory that can create token objects
 */
public class TokenFactory {

    /**
     * Represents different math operations, such as '+', '-', '*', etc.
     */
    public enum Operations {
        PLUS("+"),
        MINUS("-"),
        MULTIPLICATION("*"),
        DIVISION("/"),
        POWER("^");

        private String value;

        Operations(String value) {
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

    /**
     * Create Token object according to argument value
     *
     * @param value string value that could be a token
     * @return Token object
     * @throws IllegalArgumentException if can`t recognize string argument
     */
    public static Token getToken(String value) throws IllegalArgumentException {

        if (Operations.contains(value)) {
            return new Operation(value);
        } else if (Functions.contains(value)) {
            return new Function(value);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
