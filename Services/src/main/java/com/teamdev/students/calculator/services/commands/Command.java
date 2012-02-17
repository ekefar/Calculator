package com.teamdev.students.calculator.services.commands;

/**
 * Represent any piece of work to do
 */
public interface Command {

    /**
     * Stuff to do
     *
     * @return work`s result
     */
    double execute();
}
