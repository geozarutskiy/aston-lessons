package Lesson_7_testng;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NumberComparatorTest {
    @Test
    public void testCompareNumbersFirstGreater() {
        assertEquals(NumberComparator.compareNumbers(10, 5), "10 больше 5");
    }

    @Test
    public void testCompareNumbersFirstLess() {
        assertEquals(NumberComparator.compareNumbers(5, 10), "5 меньше 10");
    }

    @Test
    public void testCompareNumbersEqual() {
        assertEquals(NumberComparator.compareNumbers(10, 10), "Числа равны");
    }

    @Test
    public void testIsEqualTrue() {
        assertTrue(NumberComparator.isEqual(5, 5));
    }

    @Test
    public void testIsEqualFalse() {
        assertFalse(NumberComparator.isEqual(5, 10));
    }

    @Test
    public void testIsFirstGreaterTrue() {
        assertTrue(NumberComparator.isFirstGreater(10, 5));
    }

    @Test
    public void testIsFirstGreaterFalse() {
        assertFalse(NumberComparator.isFirstGreater(5, 10));
    }

    @Test
    public void testIsFirstLessTrue() {
        assertTrue(NumberComparator.isFirstLess(5, 10));
    }

    @Test
    public void testIsFirstLessFalse() {
        assertFalse(NumberComparator.isFirstLess(10, 5));
    }
}
