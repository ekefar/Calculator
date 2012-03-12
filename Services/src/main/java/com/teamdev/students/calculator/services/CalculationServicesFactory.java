package com.teamdev.students.calculator.services;

import com.teamdev.students.calculator.services.api.CalculationService;

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

}
