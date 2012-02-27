package com.teamdev.students.calculator.services;

import com.teamdev.students.calculator.model.Function;
import com.teamdev.students.calculator.model.Operation;
import com.teamdev.students.calculator.services.commands.EvaluateFunctionCommand;

import java.util.*;


/**
 * Represents object that can change calculation context
 * depending on it`s current state.
 */
public enum StateHandler implements StateAcceptor<CalculationContext> {

    START {
        @Override
        public boolean accept(CalculationContext context) {
            return false;
        }
    },
    NUMBER {
        @Override
        public boolean accept(CalculationContext context) {
            try {
                double number = Double.valueOf(context.getCurrentToken());
                context.handleOperand(number);
                context.setState(NUMBER);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    },
    OPENING_BRACKET {
        /**
         * When opening bracket occur in expression, just solve all that are
         * inside of it and put result into operand stack of the context object
         * @param context calculation context
         * @return context acceptance result
         */
        @Override
        public boolean accept(CalculationContext context) {
            if (!context.getCurrentToken().equals("(")) return false;
            try {
                String expression = context.getExpression();
                context.setBracketCount(context.getBracketCount() + 1);

                // create another one context object but with current calculation position
                CalculationContext innerContext = new CalculationContext(
                        expression.substring(context.getCalculationIndex() + 1),
                        context.getObjectsProvider());

                // create another one calculator object with new context
                Calculator calculator = new Calculator(innerContext);

                // calculate content of bracket and handle it as a simple number
                context.handleOperand(calculator.run());

                // change calculation position according to results of recursive invoke
                context.setCalculationIndex(context.getCalculationIndex() + innerContext.getCalculationIndex() + 1);
                context.setBracketCount(context.getBracketCount() + innerContext.getBracketCount());
                context.setState(NUMBER);
                return true;
            } catch (CalculationException e) {
                return false;
            }
        }
    },
    CLOSING_BRACKET {
        @Override
        public boolean accept(CalculationContext context) {
            if (!context.getCurrentToken().equals(")")) return false;
            context.setState(CLOSING_BRACKET);
            context.setBracketCount(context.getBracketCount() - 1);
            return true;
        }
    },
    OPERATION {
        @Override
        public boolean accept(CalculationContext context) {
            try {
                Operation operation = context.getOperationFactory().getOperation(context.getCurrentToken());
                context.handleOperation(operation);
                context.setState(OPERATION);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
    },
    FUNCTION {
        @Override
        public boolean accept(CalculationContext context) {
            try {
                Function function = context.getFunctionFactory().getFunction(context.getCurrentToken());
                context.setCalculationIndex(context.getCalculationIndex() + context.getCurrentToken().length());
                context.setState(FUNCTION);
                context.handleOperand(solveFunction(function, context));
                context.setState(NUMBER);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            } catch (CalculationException e) {
                return true;
            }
        }

        /**
         * Get function`s value
         *
         * @param function function to execute
         * @param context calculation context
         * @return value of function
         * @throws com.teamdev.students.calculator.services.CalculationException
         *          if there was an error during function execution
         */
        private double solveFunction(Function function, CalculationContext context) throws CalculationException {
            // list of function arguments
            List<Double> arguments = new ArrayList<Double>();

            CalculationContext innerContext;
            // extract function arguments
            do {
                // use new Calculator object to extract function arguments
                innerContext = new CalculationContext(
                        context.getExpression().substring(context.getCalculationIndex() + 1),
                        context.getObjectsProvider());
                arguments.add(new Calculator(innerContext).run());
                context.setCalculationIndex(context.getCalculationIndex() + innerContext.getCalculationIndex());
            } while (innerContext.getState() != CLOSING_BRACKET);
            context.setCalculationIndex(context.getCalculationIndex() + 1);

            // create proper command, execute it and return result of execution
            return new EvaluateFunctionCommand(function, convertToArray(arguments)).execute();

        }

        /**
         * Convert list of Double to double array
         * @param list list to convert
         * @return array of double elements
         */
        private double[] convertToArray(List<Double> list) {
            double[] simpleArray = new double[list.size()];
            for (int i = 0; i < list.size(); i++) {
                simpleArray[i] = list.get(i);
            }
            return simpleArray;
        }
    },
    DELIMITER {
        @Override
        public boolean accept(CalculationContext context) {
            if (!context.getCurrentToken().equals(",")) return false;
            context.setState(DELIMITER);
            return true;
        }
    },
    FINISH {
        @Override
        public boolean accept(CalculationContext context) {

            if (context.getCalculationIndex() > context.getExpression().length() - 1) {
                context.setState(FINISH);
                return true;
            }
            return false;
        }
    };


    /**
     * Map that contains rules of state changing.
     * Key - current state
     * Value - List of states that current state allowed to switch
     */
    private static Map<StateHandler, Set<StateHandler>> statesMap;

    static {
        statesMap = new EnumMap<StateHandler, Set<StateHandler>>(StateHandler.class);
        statesMap.put(START, EnumSet.of(OPENING_BRACKET, NUMBER, FUNCTION));
        statesMap.put(NUMBER, EnumSet.of(OPERATION, CLOSING_BRACKET, DELIMITER, FINISH));
        statesMap.put(OPENING_BRACKET, EnumSet.of(OPENING_BRACKET, FUNCTION, NUMBER));
        statesMap.put(CLOSING_BRACKET, EnumSet.of(CLOSING_BRACKET, OPERATION, DELIMITER, FINISH));
        statesMap.put(OPERATION, EnumSet.of(OPENING_BRACKET, FUNCTION, NUMBER));
        statesMap.put(FUNCTION, EnumSet.of(OPENING_BRACKET));
        statesMap.put(DELIMITER, EnumSet.of(NUMBER, FUNCTION, OPENING_BRACKET));
    }

    public static Set<StateHandler> getPossibleStates(StateHandler state) {
        return statesMap.get(state);
    }

    /**
     * Handle state of calculation context.
     *
     * @param context calculation context
     * @throws IllegalArgumentException if context can`t be handled,
     */
    public static void handleState(CalculationContext context) throws IllegalArgumentException {
        StateHandler acceptedState = null;
        for (StateHandler possibleState : getPossibleStates(context.getState())) {
            if (possibleState.accept(context)) {
                acceptedState = possibleState;
                break;
            }
        }
        if (acceptedState == null)
            throw new IllegalArgumentException();
    }
}
