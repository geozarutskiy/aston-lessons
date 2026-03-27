package lesson_7_unit_5;

public class NumberComparator {
    public static String compareNumbers(int a, int b) {
        if (a > b) {
            return a + " больше " + b;
        } else if (a < b) {
            return a + " меньше " + b;
        } else {
            return "Числа равны";
        }
    }

    public static boolean isEqual(int a, int b) {
        return a == b;
    }

    public static boolean isFirstGreater(int a, int b) {
        return a > b;
    }

    public static boolean isFirstLess(int a, int b) {
        return a < b;
    }
}
