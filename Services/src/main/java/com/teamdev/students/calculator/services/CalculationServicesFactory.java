package com.teamdev.students.calculator.services;

/**
 * Creates different calculation services
 */
public class CalculationServicesFactory {

    /**
     * Create calculation service
     *
     * @return CalculationService object
     */
    public static CalculationService createSimpleCalculationService() {
        return new CalculationServiceImpl();
    }

    public static CalculationService createExtendedCalculationService() {
        return new CalculationServiceImpl(new ExtendedTokenFactory());
    }
}
