package put.io.testing.junit;

import jdk.jfr.Threshold;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import static put.io.testing.junit.Calculator.*;

class CalculatorTest {
    private Calculator calculator;
    @BeforeEach //wyświetli błąd ponieważ setUp nie jest static
    public void setUp()
    {
        calculator = new Calculator();
    }
    @Test
    public void testAdd(){
        assertEquals(30, calculator.add(10,20),0.001);
        assertEquals(10, calculator.add(6,4),0.001);
    }
    @Test
    public void testMultiply(){
        assertEquals(200, calculator.multiply(10,20),0.001);
        assertEquals(24, calculator.multiply(6,4),0.001);
    }
    @Test
    public void testAddPositiveNumbers(){
        assertThrows(IllegalArgumentException.class,() -> {calculator.addPositiveNumbers(-1,8);});
    }
}