package com.teamdev.students.calculator.services;

import com.teamdev.students.calculator.model.Token;
import com.teamdev.students.calculator.services.commands.CommandFactory;

/**
 * Interface of factory that can create different tokens
 */
public interface TokenFactory {

    /**
     * Create new token object.
     *
     * @param value Symbolic token`s representation.
     * @return Token object
     * @throws IllegalArgumentException if value param can`t be recognized
     */
    Token getToken(String value) throws IllegalArgumentException;

    /**
     * Create command factory object for this token factory
     *
     * @return command factory object
     */
    CommandFactory getCommandFactory();

}
