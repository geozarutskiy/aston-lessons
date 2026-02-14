package lesson_6_1;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static lesson_6_1.StudentManagemen.StudentManagement.*;

public class Main {
    public static void main(String[] args) {
        // Код из примера выше
        Set<StudentManagemen.Student> students = new HashSet<>();

        students.add(new StudentManagemen.Student("Иван Иванов", "ИТ-101", 1,
                Map.of("Математика", 5, "Физика", 4, "Программирование", 5)));

        students.add(new StudentManagemen.Student("Петр Петров", "ИТ-102", 1,
                Map.of("Математика", 3, "Физика", 2, "Программирование", 2)));

        students.add(new StudentManagemen.Student("Мария Сидорова", "ИТ-201", 2,
                Map.of("Базы данных", 4, "Сети", 5, "Веб-разработка", 4)));

        students.add(new StudentManagemen.Student("Анна Козлова", "ИТ-202", 2,
                Map.of("Базы данных", 2, "Сети", 3, "Веб-разработка", 2)));

        students.add(new StudentManagemen.Student("Ольга Орлова", "ИТ-302", 3,
                Map.of("ИИ", 2, "Машинное обучение", 2, "Big Data", 2)));

        System.out.println("=== ВСЕ СТУДЕНТЫ ===");
        students.forEach(System.out::println);
        System.out.println();

        System.out.println("=== СТУДЕНТЫ ПО КУРСАМ ===");
        for (int i = 1; i <= 3; i++) {
            printStudents(students, i);
        }
        System.out.println();

        System.out.println("=== УДАЛЕНИЕ НЕУСПЕВАЮЩИХ ===");
        removeFailingStudents(students);
        students.forEach(System.out::println);
        System.out.println();

        System.out.println("=== ПЕРЕВОД НА СЛЕДУЮЩИЙ КУРС ===");
        promoteStudents(students);
        students.forEach(System.out::println);
        System.out.println();

        System.out.println("=== СТУДЕНТЫ ПОСЛЕ ПЕРЕВОДА ===");
        for (int i = 2; i <= 4; i++) {
            printStudents(students, i);
        }

        System.out.println("\n=== ПРОВЕРКА НЕСУЩЕСТВУЮЩЕГО КУРСА ===");
        printStudents(students, 5);
    }
}

