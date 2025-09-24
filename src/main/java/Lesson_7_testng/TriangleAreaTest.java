package Lesson_7_testng;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class TriangleAreaTest {
    @Test
    public void testAreaWithBaseAndHeight() {
        assertEquals(TriangleArea.calculateArea(5, 4), 10.0, 0.001);
    }

    @Test
    public void testAreaWithHeronFormula() {
        assertEquals(TriangleArea.calculateAreaHeron(3, 4, 5), 6.0, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaInvalidBase() {
        TriangleArea.calculateArea(-5, 4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaInvalidHeight() {
        TriangleArea.calculateArea(5, -4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaInvalidTriangle() {
        TriangleArea.calculateAreaHeron(1, 1, 3);
    }

}
