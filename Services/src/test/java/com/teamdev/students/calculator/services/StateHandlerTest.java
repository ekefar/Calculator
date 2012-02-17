package com.teamdev.students.calculator.services;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit tests for StateHandler class
 */
public class StateHandlerTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public StateHandlerTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(StateHandlerTest.class);
    }

    /**
     * Test state changing from START to OPENING_BRACKET
     */
    public void testStartToOpeningBracketStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.OPENING_BRACKET;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.START);
        stateHandler.handleOpeningBracket();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from START to CLOSING_BRACKET
     */
    public void testStartToClosingBracketStateChange() {

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.START);
        try {
            stateHandler.handleClosingBracket();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from START to OPERATION
     */
    public void testStartToOperationStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.START);
        try {
            stateHandler.handleOperation();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from START to FUNCTION
     */
    public void testStartToFunctionStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.FUNCTION;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.START);
        stateHandler.handleFunction();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from START to NUMBER
     */
    public void testStartToNumberStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.NUMBER;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.START);
        stateHandler.handleNumber();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from START to DELIMITER
     */
    public void testStartToDelimiterStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.START);
        try {
            stateHandler.handleDelimiter();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from START to FINISH
     */
    public void testStartToFinishStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.START);
        try {
            stateHandler.handleFinish();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }


    /*************************************************************************/

    /**
     * Test state changing from OPENING_BRACKET to OPENING_BRACKET
     */
    public void testOpeningBracketToOpeningBracketStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.OPENING_BRACKET;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.OPENING_BRACKET);
        stateHandler.handleOpeningBracket();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from OPENING_BRACKET to CLOSING_BRACKET
     */
    public void testOpeningBracketToClosingBracketStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.OPENING_BRACKET);
        try {
            stateHandler.handleClosingBracket();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from OPENING_BRACKET to OPERATION
     */
    public void testOpeningBracketToOperationStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.OPENING_BRACKET);
        try {
            stateHandler.handleOperation();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from OPENING_BRACKET to FUNCTION
     */
    public void testOpeningBracketToFunctionStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.FUNCTION;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.OPENING_BRACKET);
        stateHandler.handleFunction();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from OPENING_BRACKET to NUMBER
     */
    public void testOpeningBracketToNumberStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.NUMBER;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.OPENING_BRACKET);
        stateHandler.handleNumber();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from OPENING_BRACKET to DELIMITER
     */
    public void testOpeningBracketToDelimiterStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.OPENING_BRACKET);
        try {
            stateHandler.handleDelimiter();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from OPENING_BRACKET to FINISH
     */
    public void testOpeningBracketToFinishStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.OPENING_BRACKET);
        try {
            stateHandler.handleFinish();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /*************************************************************************/
    /**
     * Test state changing from CLOSING_BRACKET to OPENING_BRACKET
     */
    public void testClosingBracketToOpeningBracketStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.CLOSING_BRACKET);
        try {
            stateHandler.handleOpeningBracket();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from CLOSING_BRACKET to CLOSING_BRACKET
     */
    public void testClosingBracketToClosingBracketStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.CLOSING_BRACKET;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.CLOSING_BRACKET);
        stateHandler.handleClosingBracket();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from CLOSING_BRACKET to OPERATION
     */
    public void testClosingBracketToOperationStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.OPERATION;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.CLOSING_BRACKET);
        stateHandler.handleOperation();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from CLOSING_BRACKET to FUNCTION
     */
    public void testClosingBracketToFunctionStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.CLOSING_BRACKET);
        try {
            stateHandler.handleFunction();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from CLOSING_BRACKET to NUMBER
     */
    public void testClosingBracketToNumberStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.CLOSING_BRACKET);
        try {
            stateHandler.handleNumber();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from CLOSING_BRACKET to DELIMITER
     */
    public void testClosingBracketToDelimiterStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.DELIMITER;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.CLOSING_BRACKET);
        stateHandler.handleDelimiter();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from CLOSING_BRACKET to FINISH
     */
    public void testClosingBracketToFinishStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.FINISH;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.CLOSING_BRACKET);
        stateHandler.handleFinish();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /******************************************************************/
    /**
     * Test state changing from OPERATION to OPENING_BRACKET
     */
    public void testOperationToOpeningBracketStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.OPENING_BRACKET;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.OPERATION);
        stateHandler.handleOpeningBracket();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from OPERATION to CLOSING_BRACKET
     */
    public void testOperationToClosingBracketStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.OPERATION);
        try {
            stateHandler.handleClosingBracket();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from OPERATION to OPERATION
     */
    public void testOperationToOperationStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.OPERATION);
        try {
            stateHandler.handleOperation();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from OPERATION to FUNCTION
     */
    public void testOperationToFunctionStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.FUNCTION;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.OPERATION);
        stateHandler.handleFunction();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from OPERATION to NUMBER
     */
    public void testOperationToNumberStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.NUMBER;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.OPERATION);
        stateHandler.handleNumber();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from OPERATION to DELIMITER
     */
    public void testOperationToDelimiterStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.OPERATION);
        try {
            stateHandler.handleDelimiter();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from OPERATION to FINISH
     */
    public void testOperationToFinishStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.OPERATION);
        try {
            stateHandler.handleFinish();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }


    /***************************************************************************/

    /**
     * Test state changing from FUNCTION to OPENING_BRACKET
     */
    public void testFunctionToOpeningBracketStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.OPENING_BRACKET;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.FUNCTION);
        stateHandler.handleOpeningBracket();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from FUNCTION to CLOSING_BRACKET
     */
    public void testFunctionToClosingBracketStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.FUNCTION);
        try {
            stateHandler.handleClosingBracket();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from FUNCTION to OPERATION
     */
    public void testFunctionToOperationStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.FUNCTION);
        try {
            stateHandler.handleOperation();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from FUNCTION to FUNCTION
     */
    public void testFunctionToFunctionStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.FUNCTION);
        try {
            stateHandler.handleFunction();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from FUNCTION to NUMBER
     */
    public void testFunctionToNumberStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.FUNCTION);
        try {
            stateHandler.handleNumber();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from FUNCTION to DELIMITER
     */
    public void testFunctionToDelimiterStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.FUNCTION);
        try {
            stateHandler.handleDelimiter();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from FUNCTION to FINISH
     */
    public void testFunctionToFinishStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.FUNCTION);
        try {
            stateHandler.handleFinish();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /*******************************************************************/


    /**
     * Test state changing from NUMBER to OPENING_BRACKET
     */
    public void testNumberToOpeningBracketStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.NUMBER);
        try {
            stateHandler.handleOpeningBracket();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from NUMBER to CLOSING_BRACKET
     */
    public void testNumberToClosingBracketStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.CLOSING_BRACKET;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.NUMBER);
        stateHandler.handleClosingBracket();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from NUMBER to OPERATION
     */
    public void testNumberToOperationStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.OPERATION;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.NUMBER);
        stateHandler.handleOperation();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from NUMBER to FUNCTION
     */
    public void testNumberToFunctionStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.NUMBER);
        try {
            stateHandler.handleFunction();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from NUMBER to NUMBER
     */
    public void testNumberToNumberStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.NUMBER);
        try {
            stateHandler.handleNumber();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from NUMBER to DELIMITER
     */
    public void testNumberToDelimiterStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.DELIMITER;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.NUMBER);
        stateHandler.handleDelimiter();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from NUMBER to FINISH
     */
    public void testNumberToFinishStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.FINISH;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.NUMBER);
        stateHandler.handleFinish();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /****************************************************************************/

    /**
     * Test state changing from DELIMITER to OPENING_BRACKET
     */
    public void testDelimiterToOpeningBracketStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.OPENING_BRACKET;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.DELIMITER);
        stateHandler.handleOpeningBracket();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from DELIMITER to CLOSING_BRACKET
     */
    public void testDelimiterToClosingBracketStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.DELIMITER);
        try {
            stateHandler.handleClosingBracket();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from DELIMITER to OPERATION
     */
    public void testDelimiterToOperationStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.DELIMITER);
        try {
            stateHandler.handleOperation();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from DELIMITER to FUNCTION
     */
    public void testDelimiterToFunctionStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.FUNCTION;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.DELIMITER);
        stateHandler.handleFunction();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from DELIMITER to NUMBER
     */
    public void testDelimiterToNumberStateChange() {
        // expected result
        final StateHandler.States EXPECTED_RESULT = StateHandler.States.NUMBER;

        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.DELIMITER);
        stateHandler.handleNumber();

        // result assertion
        assertEquals(EXPECTED_RESULT, stateHandler.getCurrentState());
    }

    /**
     * Test state changing from DELIMITER to DELIMITER
     */
    public void testDelimiterToDelimiterStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.DELIMITER);
        try {
            stateHandler.handleDelimiter();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from DELIMITER to FINISH
     */
    public void testDelimiterToFinishStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.DELIMITER);
        try {
            stateHandler.handleFinish();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }


    /**********************************************************************/


    /**
     * Test state changing from FINISH to OPENING_BRACKET
     */
    public void testFinishToOpeningBracketStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.FINISH);
        try {
            stateHandler.handleOpeningBracket();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from FINISH to CLOSING_BRACKET
     */
    public void testFinishToClosingBracketStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.FINISH);
        try {
            stateHandler.handleClosingBracket();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from FINISH to OPERATION
     */
    public void testFinishToOperationStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.FINISH);
        try {
            stateHandler.handleOperation();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from FINISH to FUNCTION
     */
    public void testFinishToFunctionStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.FINISH);
        try {
            stateHandler.handleFunction();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from FINISH to NUMBER
     */
    public void testFinishToNumberStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.FINISH);
        try {
            stateHandler.handleNumber();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from FINISH to DELIMITER
     */
    public void testFinishToDelimiterStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.FINISH);
        try {
            stateHandler.handleDelimiter();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test state changing from FINISH to FINISH
     */
    public void testFinishToFinishStateChange() {
        StateHandler stateHandler = new StateHandler();
        stateHandler.setCurrentState(StateHandler.States.FINISH);
        try {
            stateHandler.handleFinish();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
