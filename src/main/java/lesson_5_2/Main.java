package lesson_5_2;

import static lesson_5_2.ArrayProcessor.processArray;

public class Main {
    public static void main(String[] args) {
        // Тест 1: Правильный массив
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Тест 2: Массив с буквами
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "abc", "12"}, // Ошибка здесь
                {"13", "14", "15", "16"}
        };

        // Тест 3: Массив неправильногоразмера
        String[][] wrongSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"} // Только 3 строки
        };

        try {
            System.out.println("Тест 1 - Правильный массив:");
            int result1 = processArray(correctArray);
            System.out.println("Сумма: " + result1);
            System.out.println();

        } catch (ArrayProcessor.MyArraySizeException | ArrayProcessor.MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("Тест 2 - Массив с буквами:");
            int result2 = processArray(invalidDataArray);
            System.out.println("Сумма: " + result2);
            System.out.println();

        } catch (ArrayProcessor.MyArraySizeException | ArrayProcessor.MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("Тест 3 - Массив неправильного размера:");
            int result3 = processArray(wrongSizeArray);
            System.out.println("Сумма: " + result3);
            System.out.println();

        } catch (ArrayProcessor.MyArraySizeException | ArrayProcessor.MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
