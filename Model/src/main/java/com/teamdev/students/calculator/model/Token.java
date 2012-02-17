package com.teamdev.students.calculator.model;

/**
 * Represent string token. It can be any sequence of symbols;
 * It can describe operations, functions, etc.
 */

public abstract class Token {

    /**
     * Get string representation of the token
     *
     * @return string representation of the token
     */
    public abstract String getValue();

}
