package com.teamdev.students.calculator;


import com.teamdev.students.calculator.services.CalculationException;
import com.teamdev.students.calculator.services.CalculationService;
import com.teamdev.students.calculator.services.CalculationServicesFactory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    /**
     * test case for checking '-' operation
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testMinus() throws CalculationException {
        // expected calculations result
        final double EXPECTED_RESULT = 1;
        final String EXPRESSION = "10-9";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    /**
     * test case for checking '+' operation
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testPlus() throws CalculationException {
        // expected calculations result
        final double EXPECTED_RESULT = 11;
        final String EXPRESSION = "2+2+2+5";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }


    /**
     * test case for checking brackets
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testBrackets() throws CalculationException {
        // expected calculations result
        final double EXPECTED_RESULT = 1;
        final String EXPRESSION = "4-(10-7)";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    /**
     * test case for checking brackets
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testBrackets2() throws CalculationException {
        // expected calculations result
        final double EXPECTED_RESULT = -35;
        final String EXPRESSION = "((((((5-6)+8)+1)-4)+1)-40)";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    /**
     * test case for checking brackets
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testBrackets3() throws CalculationException {
        // expected calculations result
        final double EXPECTED_RESULT = -3;
        final String EXPRESSION = "2-(1+(10-(8+(3+(1-(1+5))))))";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    /**
     * test case for checking brackets
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testBrackets4() throws CalculationException {
        // expected calculations result
        final double EXPECTED_RESULT = -11;
        final String EXPRESSION = "1-(2+5)+((2-6)+4)-(1-(2+9))-15";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }


    /**
     * test case for checking illegal symbols
     */
    public void testIllegalSymbols() {
        // expected illegal symbol position
        final int EXPECTED_RESULT = 3;
        final String EXPRESSION = "2++8";
        int actualResult = -1;
        try {
            double res = calculateExpression(EXPRESSION);
        } catch (CalculationException e) {
            actualResult = e.getInvalidTokenPosition() + 1;
        }

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    /**
     * test case for checking illegal symbols
     */
    public void testIllegalSymbols2() {
        // expected illegal symbol position
        final int EXPECTED_RESULT = 3;
        final String EXPRESSION = "-2max+8";
        int actualResult = -1;
        try {
            double res = calculateExpression(EXPRESSION);
        } catch (CalculationException e) {
            actualResult = e.getInvalidTokenPosition() + 1;
        }

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }


    /**
     * test case for checking illegal symbols
     */
    public void testIllegalSymbols3() {
        // expected illegal symbol position
        final int EXPECTED_RESULT = 7;
        final String EXPRESSION = "2+65-6+";
        int actualResult = -1;
        try {
            double res = calculateExpression(EXPRESSION);
        } catch (CalculationException e) {
            actualResult = e.getInvalidTokenPosition() + 1;
        }

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    /**
     * test case for checking illegal symbols
     */
    public void testIllegalSymbols4() {
        // expected illegal symbol position
        final int EXPECTED_RESULT = 8;
        final String EXPRESSION = "2+65-6+)78(dfsdf";
        int actualResult = -1;
        try {
            double res = calculateExpression(EXPRESSION);
        } catch (CalculationException e) {
            actualResult = e.getInvalidTokenPosition() + 1;
        }

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    /**
     * test case for checking illegal symbols
     */
    public void testIllegalSymbols5() {
        // expected illegal symbol position
        final int EXPECTED_RESULT = 3;
        final String EXPRESSION = "36)-5+2,8+(54)";
        int actualResult = -1;
        try {
            double res = calculateExpression(EXPRESSION);
        } catch (CalculationException e) {
            actualResult = e.getInvalidTokenPosition() + 1;
        }

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    /**
     * test case for checking '*' operation
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testMultiplication() throws CalculationException {
        final double EXPECTED_RESULT = 50;
        final String EXPRESSION = "5*10";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }


    /**
     * test case for checking '/' operation
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testDivision() throws CalculationException {
        final double EXPECTED_RESULT = 2;
        final String EXPRESSION = "-10/(-5)";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    /**
     * test case for checking '/' operation
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testDivisionByZero() throws CalculationException {

        final String EXPRESSION = "10/0";
        try {
            double res = calculateExpression(EXPRESSION);

        } catch (ArithmeticException e) {

            // assert exception
            assertTrue(true);
        }

    }


    /**
     * test case for checking '^' operation
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testPower() throws CalculationException {
        final double EXPECTED_RESULT = 1024;
        final String EXPRESSION = "2^10";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    /**
     * test case for checking sqrt function
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testSqrtFunction() throws CalculationException {
        final double EXPECTED_RESULT = 5;
        final String EXPRESSION = "sqrt(25)";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    /**
     * test case for checking max function
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testMaxFunction() throws CalculationException {
        final double EXPECTED_RESULT = 25;
        final String EXPRESSION = "max(25,-5)";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    /**
     * test case for checking max function
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testMaxFunction2() throws CalculationException {
        final double EXPECTED_RESULT = 82;
        final String EXPRESSION = "max(25,-5,min(82,10000))";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    /**
     * test case for checking min function
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testMinFunction() throws CalculationException {
        final double EXPECTED_RESULT = -5;
        final String EXPRESSION = "min(10,-5)";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    /**
     * test case for checking min function
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testMinFunction2() throws CalculationException {
        final double EXPECTED_RESULT = 1;
        final String EXPRESSION = "min(100,50,20,10,5,1)";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }


    /**
     * test case for sum function
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testSumFunction() throws CalculationException {
        final double EXPECTED_RESULT = 60;
        final String EXPRESSION = "sum(min(5,10),5,5,5,5+5,5+5+5+5+5*2)";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    /**
     * test case for checking sum function
     *
     * @throws com.teamdev.students.calculator.services.CalculationException
     *          if fail
     */
    public void testSumFunction2() throws CalculationException {
        final double EXPECTED_RESULT = 34;
        final String EXPRESSION = "sum(25+5,min(30-8,2),5*2-(5+8),5)";
        double actualResult = calculateExpression(EXPRESSION);

        // assert equality of expected and actual results
        assertEquals(EXPECTED_RESULT, actualResult);
    }


    public double calculateExpression(String expression) throws CalculationException {
        CalculationService calculationService = CalculationServicesFactory.createSimpleCalculationService();
        return calculationService.calculate(expression);
    }
}
