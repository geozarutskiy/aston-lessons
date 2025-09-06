package lesson_2;

public class main6 {
    public static void main(String[] args) {
        System.out.println("6. checkNumberSign():");
        checkNumberSign(10);
        checkNumberSign(-5);
        checkNumberSign(0);
        System.out.println();
    }
    public static void checkNumberSign(int number) {
        if (number >= 0) {
            System.out.println(number + " - положительное число");
        } else {
            System.out.println(number + " - отрицательное число");
        }
    }
}
