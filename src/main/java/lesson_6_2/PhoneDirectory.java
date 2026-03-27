package lesson_6_2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class PhoneDirectory {

        private Map<String, List<String>> phoneBook;

        public PhoneDirectory() {
            phoneBook = new HashMap<>();
        }

        public void add(String surname, String phoneNumber) {
            if (!phoneBook.containsKey(surname)) {
                phoneBook.put(surname, new ArrayList<>());
            }
            phoneBook.get(surname).add(phoneNumber);
        }

        public List<String> get(String surname) {
            return phoneBook.getOrDefault(surname, new ArrayList<>());
        }

        public void printAll() {
            for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
