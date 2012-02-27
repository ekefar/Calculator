package com.teamdev.students.calculator.services;

/**
 * Represents interface of context acceptance.
 */
public interface StateAcceptor<Context> {
    boolean accept(Context context);
}
