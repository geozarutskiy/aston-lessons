package Lesson_7_testng;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class ArithmeticOperationsTest {
    @Test
    public void testAddition() {
        assertEquals(ArithmeticOperations.add(10, 5), 15);
    }

    @Test
    public void testSubtraction() {
        assertEquals(ArithmeticOperations.subtract(10, 5), 5);
    }

    @Test
    public void testMultiplication() {
        assertEquals(ArithmeticOperations.multiply(10, 5), 50);
    }

    @Test
    public void testDivision() {
        assertEquals(ArithmeticOperations.divide(10, 5), 2.0, 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        ArithmeticOperations.divide(10, 0);
    }

    @Test
    public void testDivisionWithRemainder() {
        assertEquals(ArithmeticOperations.divide(10, 3), 3.333, 0.001);
    }

}
