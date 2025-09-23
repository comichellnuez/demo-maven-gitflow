package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @Test
    void testAddUnit() {
        CalculatorService service = new CalculatorService();
        int result = service.add(2, 3);
        assertEquals(5, result, "2 + 3 should be 5");
    }
}

