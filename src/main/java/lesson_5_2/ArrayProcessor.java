package lesson_5_2;

public class ArrayProcessor {
    // Убираем неправильный размер массива
    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    // Убираем неверные данные в ячейке
    static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Смотрим размер массива
        checkArraySize(array);

        int sum = 0;

        // Проходим по всем элементам массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    // Пытаемся преобразовать строку в число и добавить к сумме
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    // Если преобразование не удалось, бросаем наше исключение
                    throw new MyArrayDataException(
                            String.format("Неверные данные в ячейке [%d][%d]: '%s' не является числом",
                                    i, j, array[i][j])
                    );
                }
            }
        }

        return sum;
    }

    // Проверка размера массива
    private static void checkArraySize(String[][] array) throws MyArraySizeException {
        if (array == null) {
            throw new MyArraySizeException("Массив не может быть null");
        }

        if (array.length != 4) {
            throw new MyArraySizeException(
                    String.format("Неверное количество строк: ожидается 4, получено %d", array.length)
            );
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new MyArraySizeException(
                        String.format("Строка %d не может быть null", i)
                );
            }

            if (array[i].length != 4) {
                throw new MyArraySizeException(
                        String.format("Неверное количество столбцов в строке %d: ожидается 4, получено %d",
                                i, array[i].length)
                );
            }
        }
    }
}




