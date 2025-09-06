package lesson_2;

public class main14 {
    public static void main(String[] args) {
        System.out.println("14. createArray():");
        int[] array4 = createArray(5, 42);
        System.out.print("Массив из 5 элементов со значением 42: ");
        printArray(array4);
    }
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
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
