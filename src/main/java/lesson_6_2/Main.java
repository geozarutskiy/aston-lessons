package lesson_6_2;

public class Main {
    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory();

        directory.add("Ivanov", "+7-999-123-45-67");
        directory.add("Petrov", "+7-999-765-43-21");
        directory.add("Ivanov", "+7-999-888-77-66");
        directory.add("Sidorov", "+7-999-555-44-33");

        System.out.println("Ivanov's numbers: " + directory.get("Ivanov"));
        System.out.println("Petrov's numbers: " + directory.get("Petrov"));
        System.out.println("Non-existent surname: " + directory.get("Kuznetsov"));

        System.out.println("\nFull directory:");
        directory.printAll();
    }
}

