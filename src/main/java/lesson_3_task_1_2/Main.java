package lesson_3_task_1_2;

public class Main {
    public static void main(String[] args) {

        Product[] products = new Product[5];

        products[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599.99, true);

        products[1] = new Product("iPhone 15 Pro", "15.09.2023",
                "Apple Inc.", "USA", 4999.99, false);

        products[2] = new Product("Xiaomi Mi 13", "20.03.2023",
                "Xiaomi Corporation", "China", 2999.99, true);

        products[3] = new Product("Sony PlayStation 5", "12.11.2020",
                "Sony Interactive Entertainment", "Japan", 4499.99, false);

        products[4] = new Product("MacBook Air M2", "08.07.2022",
                "Apple Inc.", "USA", 3999.99, true);

        System.out.println("СПИСОК ТОВАРОВ:");
        System.out.println("===============");

        for (int i = 0; i < products.length; i++) {
            System.out.println("Товар #" + (i + 1) + ":");
            products[i].displayInfo();
            System.out.println();
        }
    }
}
