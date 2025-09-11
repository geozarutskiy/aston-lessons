package lesson_2;

public class main7 {
    public static void main(String[] args) {
        System.out.println("7. isNegative():");
        System.out.println("-5 отрицательное: " + isNegative(-5));
        System.out.println("10 отрицательное: " + isNegative(10));
        System.out.println("0 отрицательное: " + isNegative(0));
        System.out.println();
    }
    public static boolean isNegative(int number) {
        return number < 0;
    }
}
