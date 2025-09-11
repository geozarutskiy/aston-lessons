package lesson_4_2;


    import java.awt.Color;

    // Интерфейс для геометрических фигур
    interface GeometricShape {
        // Методы для расчета периметра и площади
        double calculatePerimeter();

        double calculateArea();

        // Методы для получения цветов
        Color getFillColor();

        Color getBorderColor();

        // Метод для получения названия фигуры
        String getName();

        // Дефолтный метод для вывода информации
        default void printInfo() {
            System.out.printf("%s: Периметр = %.2f, Площадь = %.2f, Цвет фона = %s, Цвет границ = %s%n",
                    getName(),
                    calculatePerimeter(),
                    calculateArea(),
                    colorToString(getFillColor()),
                    colorToString(getBorderColor()));
        }

        // Вспомогательный метод для преобразования цвета в строку
        private static String colorToString(Color color) {
            if (color == Color.RED) return "Красный";
            if (color == Color.GREEN) return "Зеленый";
            if (color == Color.BLUE) return "Синий";
            if (color == Color.YELLOW) return "Желтый";
            if (color == Color.ORANGE) return "Оранжевый";
            if (color == Color.BLACK) return "Черный";
            if (color == Color.WHITE) return "Белый";
            if (color == Color.CYAN) return "Голубой";
            if (color == Color.MAGENTA) return "Пурпурный";
            return "RGB(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ")";
        }
    }

    // Класс Круг
    class Circle implements GeometricShape {
        private double radius;
        private Color fillColor;
        private Color borderColor;
        private String name;

        public Circle(String name, double radius, Color fillColor, Color borderColor) {
            this.name = name;
            this.radius = radius;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public Color getFillColor() {
            return fillColor;
        }

        @Override
        public Color getBorderColor() {
            return borderColor;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    // Класс Прямоугольник
    class Rectangle implements GeometricShape {
        private double width;
        private double height;
        private Color fillColor;
        private Color borderColor;
        private String name;

        public Rectangle(String name, double width, double height, Color fillColor, Color borderColor) {
            this.name = name;
            this.width = width;
            this.height = height;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * (width + height);
        }

        @Override
        public double calculateArea() {
            return width * height;
        }

        @Override
        public Color getFillColor() {
            return fillColor;
        }

        @Override
        public Color getBorderColor() {
            return borderColor;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    // Класс Треугольник
    class Triangle implements GeometricShape {
        private double sideA;
        private double sideB;
        private double sideC;
        private Color fillColor;
        private Color borderColor;
        private String name;

        public Triangle(String name, double sideA, double sideB, double sideC, Color fillColor, Color borderColor) {
            this.name = name;
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double calculatePerimeter() {
            return sideA + sideB + sideC;
        }

        @Override
        public double calculateArea() {
            // Используем формулу Герона
            double s = calculatePerimeter() / 2;
            return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        }

        @Override
        public Color getFillColor() {
            return fillColor;
        }

        @Override
        public Color getBorderColor() {
            return borderColor;
        }

        @Override
        public String getName() {
            return name;
        }
    }



