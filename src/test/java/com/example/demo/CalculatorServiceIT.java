package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceIT {

    @Test
    void testAddIntegration() {
        // Aquí simulas la "integración" entre componentes
        CalculatorService service = new CalculatorService();
        int result = service.add(5, 7);
        assertEquals(12, result, "5 + 7 should be 12");
    }
}

