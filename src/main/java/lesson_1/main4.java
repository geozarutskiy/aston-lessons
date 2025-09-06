package lesson_1;

public class main4 {

    public static void main(String[] args) {
        System.out.println("4. compareNumbers():");
        compareNumbers();
        System.out.println();
    }

    public static void compareNumbers() {
        int a = 25;
        int b = 20;

        if (a >= b) {
            System.out.println("a >= b (" + a + " >= " + b + ")");
        } else {
            System.out.println("a < b (" + a + " < " + b + ")");
        }
    }
}
