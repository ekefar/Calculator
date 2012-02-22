package com.teamdev.students.calculator.services;

import java.util.*;

/**
 * Represents object, that can handle parsing state changing
 */
class StateHandler {

    // possible states
    enum States {
        START,
        NUMBER,
        OPENING_BRACKET,
        CLOSING_BRACKET,
        OPERATION,
        FUNCTION,
        DELIMITER,
        FINISH
    }

    /**
     * Map that contains rules of state changing.
     * Key - current state
     * Value - List of states that current state allowed to switch
     */
    static Map<States, List<States>> statesMap;


    static {
        statesMap = new EnumMap<States, List<States>>(States.class);
        statesMap.put(States.START, Arrays.asList(States.OPENING_BRACKET, States.NUMBER, States.FUNCTION));
        statesMap.put(States.NUMBER, Arrays.asList(States.OPERATION, States.CLOSING_BRACKET, States.DELIMITER, States.FINISH));
        statesMap.put(States.OPENING_BRACKET, Arrays.asList(States.OPENING_BRACKET, States.FUNCTION, States.NUMBER));
        statesMap.put(States.CLOSING_BRACKET, Arrays.asList(States.CLOSING_BRACKET, States.OPERATION, States.DELIMITER, States.FINISH));
        statesMap.put(States.OPERATION, Arrays.asList(States.OPENING_BRACKET, States.FUNCTION, States.NUMBER));
        statesMap.put(States.FUNCTION, Arrays.asList(States.OPENING_BRACKET));
        statesMap.put(States.DELIMITER, Arrays.asList(States.NUMBER, States.FUNCTION, States.OPENING_BRACKET));
        statesMap.put(States.FINISH, new ArrayList<States>());
    }

    // current currentState
    private States currentState = States.START;

    /**
     * Check if current state can be switched to another one
     *
     * @param state target state
     * @return true if can.
     */
    private boolean canChangeTo(States state) {
        List<States> allowedStates = statesMap.get(currentState);
        return allowedStates.contains(state);
    }

    /**
     * set current state
     *
     * @param currentState currentState value
     */
    public void setCurrentState(States currentState) {
        this.currentState = currentState;
    }

    public States getCurrentState() {
        return currentState;
    }

    /**
     * Handle state changing to finish value
     *
     * @throws IllegalArgumentException if state changing is impossible.
     */
    public void handleFinish() throws IllegalArgumentException {
        if (canChangeTo(States.FINISH))
            currentState = States.FINISH;
        else
            throw new IllegalArgumentException();
    }

    /**
     * Handle state changing to OpeningBracket value
     *
     * @throws IllegalArgumentException if state changing is impossible.
     */
    public void handleOpeningBracket() throws IllegalArgumentException {
        if (canChangeTo(States.OPENING_BRACKET))
            currentState = States.OPENING_BRACKET;
        else
            throw new IllegalArgumentException();
    }

    /**
     * Handle state changing to CloseBracket value
     *
     * @throws IllegalArgumentException if state changing is impossible.
     */
    public void handleClosingBracket() throws IllegalArgumentException {
        if (canChangeTo(States.CLOSING_BRACKET))
            currentState = States.CLOSING_BRACKET;
        else
            throw new IllegalArgumentException();
    }

    /**
     * Handle state changing to number value
     *
     * @throws IllegalArgumentException if state changing is impossible.
     */
    public void handleNumber() throws IllegalArgumentException {
        if (canChangeTo(States.NUMBER))
            currentState = States.NUMBER;
        else
            throw new IllegalArgumentException();
    }

    /**
     * Handle state changing to function value
     *
     * @throws IllegalArgumentException if state changing is impossible.
     */
    public void handleFunction() throws IllegalArgumentException {
        if (canChangeTo(States.FUNCTION))
            currentState = States.FUNCTION;
        else
            throw new IllegalArgumentException();
    }

    /**
     * Handle state changing to delimiter value
     *
     * @throws IllegalArgumentException if state changing is impossible.
     */
    public void handleDelimiter() throws IllegalArgumentException {
        if (canChangeTo(States.DELIMITER))
            currentState = States.DELIMITER;
        else
            throw new IllegalArgumentException();
    }

    /**
     * Handle state changing to operation value
     *
     * @throws IllegalArgumentException if state changing is impossible.
     */
    public void handleOperation() throws IllegalArgumentException {
        if (canChangeTo(States.OPERATION))
            currentState = States.OPERATION;
        else
            throw new IllegalArgumentException();
    }
}
