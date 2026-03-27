package lesson_7_unit_5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TriangleAreaTest {
    @Test
    void testAreaWithBaseAndHeight() {
        assertEquals(10.0, TriangleArea.calculateArea(5, 4), 0.001);
    }

    @Test
    void testAreaWithHeronFormula() {
        assertEquals(6.0, TriangleArea.calculateAreaHeron(3, 4, 5), 0.001);
    }

    @Test
    void testAreaInvalidBase() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateArea(-5, 4);
        });
    }

    @Test
    void testAreaInvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateArea(5, -4);
        });
    }

    @Test
    void testAreaInvalidTriangle() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaHeron(1, 1, 3);
        });
    }
}
