package lesson_6;

import static lesson_6.ArrayProcessor.demonstrateArrayIndexOutOfBounds;
import static lesson_6.ArrayProcessor.processArray;

public class Main {
    public static void main(String[] args) {
        // Тест 1: Корректный массив
        System.out.println("=== Тест 1: Корректный массив ===");
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(correctArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Тест 2: Неверный размер массива
        System.out.println("\n=== Тест 2: Неверный размер массива ===");
        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        try {
            int result = processArray(wrongSizeArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Тест 3: Неверные данные в массиве
        System.out.println("\n=== Тест 3: Неверные данные в массиве ===");
        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "шесть", "7", "8"}, // Неверные данные
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(wrongDataArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Демонстрация ArrayIndexOutOfBoundsException
        System.out.println("\n=== Демонстрация ArrayIndexOutOfBoundsException ===");
        demonstrateArrayIndexOutOfBounds();

        // Дополнительный тест: смешанный случай
        System.out.println("\n=== Тест 4: Массив 3x4 (неверный размер) ===");
        String[][] mixedArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"} // Только 3 строки вместо 4
        };

        try {
            int result = processArray(mixedArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

