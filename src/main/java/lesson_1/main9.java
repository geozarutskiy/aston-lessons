package lesson_1;

public class main9 {
    public static void main(String[] args) {
        System.out.println("9. isLeapYear():");
        System.out.println("2020 високосный: " + isLeapYear(2020));
        System.out.println("1900 високосный: " + isLeapYear(1900));
        System.out.println("2000 високосный: " + isLeapYear(2000));
        System.out.println("2023 високосный: " + isLeapYear(2023));
        System.out.println();
    }
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
