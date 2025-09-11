package lesson_2;

public class main11 {
    public static void main(String[] args) {
        System.out.println("11. fillArray():");
        int[] array2 = fillArray();
        System.out.print("Массив от 1 до 100: ");
        printArray(array2);
        System.out.println();
    }
    public static int[] fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
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
