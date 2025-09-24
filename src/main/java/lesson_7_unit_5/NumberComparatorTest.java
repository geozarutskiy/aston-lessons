package lesson_7_unit_5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class NumberComparatorTest {
    @Test
    void testCompareNumbersFirstGreater() {
        assertEquals("10 больше 5", NumberComparator.compareNumbers(10, 5));
    }

    @Test
    void testCompareNumbersFirstLess() {
        assertEquals("5 меньше 10", NumberComparator.compareNumbers(5, 10));
    }

    @Test
    void testCompareNumbersEqual() {
        assertEquals("Числа равны", NumberComparator.compareNumbers(10, 10));
    }

    @Test
    void testIsEqualTrue() {
        assertTrue(NumberComparator.isEqual(5, 5));
    }

    @Test
    void testIsEqualFalse() {
        assertFalse(NumberComparator.isEqual(5, 10));
    }

    @Test
    void testIsFirstGreaterTrue() {
        assertTrue(NumberComparator.isFirstGreater(10, 5));
    }

    @Test
    void testIsFirstGreaterFalse() {
        assertFalse(NumberComparator.isFirstGreater(5, 10));
    }

    @Test
    void testIsFirstLessTrue() {
        assertTrue(NumberComparator.isFirstLess(5, 10));
    }

    @Test
    void testIsFirstLessFalse() {
        assertFalse(NumberComparator.isFirstLess(10, 5));
    }
}
