package lesson_6;

public class ArrayProcessor {
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (array.length != 4) {
            throw new MyArraySizeException("Неверное количество строк. Ожидается: 4, получено: " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Неверное количество столбцов в строке " + i + ". Ожидается: 4, получено: " + array[i].length);
            }
        }

        int sum = 0;

        // Проход по всем элементам массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    // Пытаемся преобразовать строку в число
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    // Бросаем наше пользовательское исключение
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: '" + array[i][j] + "'");
                }
            }
        }

        return sum;
    }

    // Метод для генерации и поимки ArrayIndexOutOfBoundsException
    public static void demonstrateArrayIndexOutOfBounds() {
        try {
            int[] array = new int[5];
            // Попытка доступа к несуществующему элементу
            int value = array[10]; // Это вызовет ArrayIndexOutOfBoundsException
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Индекс вышел за границы массива!");
        }
    }
}
