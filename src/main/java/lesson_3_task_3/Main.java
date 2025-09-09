package lesson_3_task_3;

public class Main {
    public static void main(String[] args) {
        // Создаем парк
        Park disneyland = new Park("Диснейленд", "Париж, Франция");

        // Создаем аттракционы (внутренние объекты)
        Park.Attraction[] attractions = new Park.Attraction[5];

        attractions[0] = disneyland.new Attraction("Американские горки", "10:00-20:00", 500, 12);
        attractions[1] = disneyland.new Attraction("Колесо обозрения", "09:00-22:00", 300, 6);
        attractions[2] = disneyland.new Attraction("Водные горки", "11:00-19:00", 400, 10);
        attractions[3] = disneyland.new Attraction("Детская карусель", "10:00-18:00", 200, 3);
        attractions[4] = disneyland.new Attraction("Комната страха", "14:00-23:00", 350, 16);

        // Добавляем аттракционы в парк
        disneyland.addAttractions(attractions);

        // Выводим информацию о парке
        disneyland.displayParkInfo();

        // Демонстрация дополнительных методов
        System.out.println("ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ:");
        System.out.println("=========================");

        double totalCost = disneyland.calculateTotalCost();
        System.out.println("Общая стоимость всех аттракционов: " + totalCost + " руб.");
        System.out.println("Средняя стоимость аттракциона: " +
                (totalCost / attractions.length) + " руб.");

        System.out.println();
    }

}

