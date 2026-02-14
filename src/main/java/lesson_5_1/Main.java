package lesson_5_1;

import static lesson_5_1.ArrayProcessor.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Правильный массив
            String[][] correctArray = {
                    {"1", "2", "3", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "10", "11", "12"},
                    {"13", "14", "15", "16"}
            };
            processArray(correctArray);

            // Неправильный массив (3x4)
            String[][] wrongSizeArray = {
                    {"1", "2", "3", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "10", "11", "12"}
            };
            processArray(wrongSizeArray);

        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
