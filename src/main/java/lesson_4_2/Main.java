package lesson_4_2;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Создаем массив геометрических фигур
        GeometricShape[] shapes = {
                new Circle("Круг", 5.0, Color.RED, Color.BLACK),
                new Rectangle("Прямоугольник", 4.0, 6.0, Color.BLUE, Color.WHITE),
                new Triangle("Треугольник", 3.0, 4.0, 5.0, Color.GREEN, Color.YELLOW),
                new Circle("Маленький круг", 2.5, Color.CYAN, Color.MAGENTA),
                new Rectangle("Квадрат", 5.0, 5.0, Color.ORANGE, Color.BLACK)
        };

        System.out.println("=== ХАРАКТЕРИСТИКИ ГЕОМЕТРИЧЕСКИХ ФИГУР ===\n");

        // Выводим информацию о каждой фигуре
        for (GeometricShape shape : shapes) {
            shape.printInfo();
        }

        // Дополнительная информация
        System.out.println("\n=== ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ ===");
        for (GeometricShape shape : shapes) {
            System.out.printf("%s: Периметр ≈ %.2f, Площадь ≈ %.2f%n",
                    shape.getName(),
                    shape.calculatePerimeter(),
                    shape.calculateArea());
        }
    }
}

