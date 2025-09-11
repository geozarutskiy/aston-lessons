package lesson_2;

public class main3 {
    public static void main(String[] args) {
        System.out.println("3. printColor():");
        printColor();
        System.out.println();
    }
    public static void printColor() {
        int value = 75;

        if (value <= 0) {
            System.out.println("Красный (value = " + value + ")");
        } else if (value <= 100) {
            System.out.println("Желтый (value = " + value + ")");
        } else {
            System.out.println("Зеленый (value = " + value + ")");
        }
    }
}
