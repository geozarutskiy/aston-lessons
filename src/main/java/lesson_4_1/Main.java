package lesson_4_1;

public class Main {
    public static void main(String[] args) {
        // Создаем животных
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");
        Cat cat3 = new Cat("Васька");

        System.out.println("=== Тестирование бега и плавания ===");

        // Тестируем бег и плавание
        dog1.run(300);
        dog1.run(600);
        dog1.swim(5);
        dog1.swim(15);

        cat1.run(150);
        cat1.run(250);
        cat1.swim(10);

        // Работа с миской и котами
        Bowl bowl = new Bowl(25);

        Cat[] cats = {cat1, cat2, cat3};

        System.out.println("\n=== Кормление котов ===");
        System.out.println("Начальное количество еды в миске: " + bowl.getFoodAmount());

        for (Cat cat : cats) {
            cat.eatFromBowl(bowl, 10);
        }

        System.out.println("\n=== Состояние сытости котов ===");
        for (Cat cat : cats) {
            System.out.println(cat.name + ": " + (cat.isFull() ? "сыт" : "голоден"));
        }

        System.out.println("Остаток еды в миске: " + bowl.getFoodAmount());

        // Добавляем еду и кормим голодных котов снова
        System.out.println("\n=== Добавление еды и повторное кормление ===");
        bowl.addFood(20);

        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eatFromBowl(bowl, 10);
            }
        }

        // Статистика
        System.out.println("\n=== Статистика ===");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());
        System.out.println("Финальный остаток еды в миске: " + bowl.getFoodAmount());
    }
}

