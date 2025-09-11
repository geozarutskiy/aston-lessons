package lesson_4_1;

public class Animal {
    protected String name;
    private static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}

// Класс Собака
class Dog extends Animal {
    private static int dogCount = 0;
    private final int MAX_RUN_DISTANCE = 500;
    private final int MAX_SWIM_DISTANCE = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. (максимум: " + MAX_RUN_DISTANCE + " м.)");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            super.swim(distance);
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. (максимум: " + MAX_SWIM_DISTANCE + " м.)");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}

// Класс Кот
class Cat extends Animal {
    private static int catCount = 0;
    private final int MAX_RUN_DISTANCE = 200;
    private boolean isFull; // сытость

    public Cat(String name) {
        super(name);
        this.isFull = false; // изначально голоден
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. (максимум: " + MAX_RUN_DISTANCE + " м.)");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }

    // Метод для питания из миски
    public void eatFromBowl(Bowl bowl, int foodAmount) {
        if (bowl.decreaseFood(foodAmount)) {
            this.isFull = true;
            System.out.println(name + " поел " + foodAmount + " еды и теперь сыт!");
        } else {
            System.out.println(name + " не смог поесть. В миске недостаточно еды (" + bowl.getFoodAmount() + " из " + foodAmount + " требуемых)");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}

// Класс Миска
class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        this.foodAmount = Math.max(initialFood, 0); // гарантируем неотрицательное значение
    }

    // Попытка взять еду из миски
    public boolean decreaseFood(int amount) {
        if (amount > 0 && amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    // Добавить еду в миску
    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("Добавлено " + amount + " еды в миску. Теперь в миске: " + foodAmount);
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}

