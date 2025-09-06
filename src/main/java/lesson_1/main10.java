package lesson_1;


public class main10 {
        public static void main(String[] args) {
                System.out.println("10. invertArray():");
                int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
                System.out.print("Исходный массив: ");
                printArray(array1);
                invertArray(array1);
                System.out.print("Инвертированный массив: ");
                printArray(array1);
                System.out.println();
        }

        private static void invertArray(int[] array1) {
                for (int i = 0; i < array.length; i++) {
                        if (array[i] == 0) {
                                array[i] = 1;
                        } else {
                                array[i] = 0;
                        }
                }
        }


        private static void printArray(int[] array1) {
                for (int i = 0; i < array.length; i++) {
                        if (array[i] == 0) {
                                array[i] = 1;
                        } else {
                                array[i] = 0;
                        }
                }
        }
}




          