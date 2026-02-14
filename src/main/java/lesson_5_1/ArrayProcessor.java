package lesson_5_1;

public class ArrayProcessor {

    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    public static void processArray(String[][] array) throws MyArraySizeException {
        // Проверяем, что массив не null
        if (array == null) {
            throw new MyArraySizeException("Массив не может быть null");
        }

        // Проверяем количество строк
        if (array.length != 4) {
            throw new MyArraySizeException(
                    String.format("Неверное количество строк: ожидается 4, получено %d", array.length)
            );
        }

        // Проверяем количество столбцов в каждой строке
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

        // Если все проверки пройдены, можно выполнять основную логику
        System.out.println("Массив корректен, можно выполнять обработку");
        // Здесь ваша основная логика обработки массива
    }
}
