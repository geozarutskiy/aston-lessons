package lesson_2;

public class main12 {
    public static void main(String[] args) {
        System.out.println("12. multiplyLessThanSix():");
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("Исходный массив: ");
        printArray(array3);
        multiplyLessThanSix(array3);
        System.out.print("После умножения: ");
        printArray(array3);
        System.out.println();
    }
    public static void multiplyLessThanSix(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
