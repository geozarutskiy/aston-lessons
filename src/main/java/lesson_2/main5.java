package lesson_2;

public class main5 {
    public static void main(String[] args) {
        System.out.println("5. sumInRange():");
        System.out.println("Сумма 5 и 7: " + sumInRange(5, 7));
        System.out.println("Сумма 10 и 5: " + sumInRange(10, 5));
        System.out.println("Сумма 20 и 1: " + sumInRange(20, 1));
        System.out.println();
    }
    public static boolean sumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
}
