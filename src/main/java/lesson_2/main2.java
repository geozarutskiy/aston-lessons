package lesson_2;

public class main2 {
    public static void main(String[] args) {
        System.out.println("2. checkSumSign():");
        checkSumSign();
        System.out.println();
    }

    public static void checkSumSign() {
        int a = 15;
        int b = -7;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная: " + sum);
        } else {
            System.out.println("Сумма отрицательная: " + sum);
        }
    }
}
