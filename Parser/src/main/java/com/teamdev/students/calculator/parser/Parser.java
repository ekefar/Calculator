package com.teamdev.students.calculator.parser;

/**
 * Interface that can handle parsing string into tokens.
 */

public interface Parser {

    /**
     * Returns true if parsing string has more elements to parse.
     *
     * @return true if more tokens can be parsed.
     */
    boolean hasNext();

    /**
     * Get value that represents position of last parsed lexeme in source string.
     *
     * @return currently parsing position value.
     */
    int getParsingPosition();

    /**
     * Get value that represents position of last parsed lexeme in source string.
     *
     * @param parsingPosition parsing position
     */
    void setParsingPosition(int parsingPosition);

    /**
     * Return next parsed symbolic sequence.
     *
     * @return parsed lexeme
     * @throws IllegalArgumentException expression to parse is invalid.
     */
    String parseNext() throws IllegalArgumentException;
}
