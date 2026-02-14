package lesson_5_4;

public class ArrayIndexExceptionDemo {
    public static void main(String[] args) {
        // Создаем массив из 3 элементов
        int[] numbers = {1, 2, 3};

        System.out.println("Массив: [1, 2, 3]");
        System.out.println("Длина массива: " + numbers.length);
        System.out.println("Валидные индексы: 0, 1, 2");
        System.out.println();

        try {
            // Попытка доступа к несуществующему элементу
            System.out.println("Попытка получить numbers[5]:");
            int value = numbers[5]; // Здесь возникнет исключение
            System.out.println("Значение: " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(" !!!Поймано ArrayIndexOutOfBoundsException!!!");
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Причина: попытка доступа к индексу 5 в массиве длиной 3");
        }

        System.out.println();
        System.out.println("Программа продолжает работу после обработки исключения!");
    }
}
