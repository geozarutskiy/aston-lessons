package lesson_5_3;

public class Main {
    public static void main(String[] args) {
        // Создаем тестовые массивы
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "abc", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        String[][] nullArray = null;

        String[][] wrongColumnsArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Тестируем разные сценарии
        System.out.println("=== Тестирование обработки массива 4x4 ===");
        System.out.println();


    }
}