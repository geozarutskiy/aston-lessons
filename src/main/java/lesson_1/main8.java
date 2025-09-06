package lesson_1;

public class main8 {
    public static void main(String[] args) {
        System.out.println("8. printStringMultipleTimes():");
        printStringMultipleTimes("Hello Java!", 3);
        System.out.println();
    }
    public static void printStringMultipleTimes(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }
}
