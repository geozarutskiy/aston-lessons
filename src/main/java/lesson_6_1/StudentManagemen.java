package lesson_6_1;
import java.util.*;
public class StudentManagemen {
    static class Student {
        private String name;
        private String group;
        private int course;
        private Map<String, Integer> grades;

        // Конструктор
        public Student(String name, String group, int course, Map<String, Integer> grades) {
            this.name = name;
            this.group = group;
            this.course = course;
            this.grades = new HashMap<>(grades);
        }

        // Геттеры и сеттеры
        public String getName() {
            return name;
        }

        public int getCourse() {
            return course;
        }

        public void setCourse(int course) {
            this.course = course;
        }

        // Метод для расчета среднего балла
        public double getAverageGrade() {
            if (grades.isEmpty()) {
                return 0.0;
            }
            int sum = 0;
            for (int grade : grades.values()) {
                sum += grade;
            }
            return (double) sum / grades.size();
        }

        // Переопределенные методы для корректной работы с коллекциями
        @Override
        public String toString() {
            return "Student{name='" + name + "', group='" + group +
                    "', course=" + course + ", average=" + String.format("%.2f", getAverageGrade()) + "}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return course == student.course &&
                    Objects.equals(name, student.name) &&
                    Objects.equals(group, student.group);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, group, course);
        }
    }
    public static class StudentManagement {

        // Метод для удаления студентов со средним баллом < 3
        public static void removeFailingStudents(Set<Student> students) {
            students.removeIf(student -> student.getAverageGrade() < 3.0);
        }

        // Метод для перевода студентов на следующий курс
        public static void promoteStudents(Set<Student> students) {
            for (Student student : students) {
                if (student.getAverageGrade() >= 3.0) {
                    student.setCourse(student.getCourse() + 1);
                }
            }
        }

        // Метод для печати студентов определенного курса
        public static void printStudents(Set<Student> students, int course) {
            System.out.println("Студенты " + course + " курса:");
            boolean found = false;

            for (Student student : students) {
                if (student.getCourse() == course) {
                    System.out.println("- " + student.getName() +
                            " (группа: " + student.getCourse() +
                            ", средний балл: " + String.format("%.2f", student.getAverageGrade()) + ")");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("На " + course + " курсе нет студентов.");
            }
        }
        }
    }

