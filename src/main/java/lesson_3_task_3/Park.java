package lesson_3_task_3;

public class Park {
    private String parkName;
    private String location;
    private Attraction[] attractions;

    public class Attraction {
        private String attractionName;
        private String workingHours;
        private double price;

        public Attraction(String attractionName, String workingHours, double price, int minAge) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void displayAttractionInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println("----------------------------");
        }

        public String getAttractionName() {
            return attractionName;
        }

        public String getWorkingHours() {
            return workingHours;
        }

        public double getPrice() {
            return price;
        }
    }
    public Park(String parkName, String location) {
        this.parkName = parkName;
        this.location = location;
        this.attractions = new Attraction[0];
    }
    public void addAttractions(Attraction[] newAttractions) {
        this.attractions = newAttractions;
    }
    public void displayParkInfo() {

        System.out.println("Название: " + parkName);
        System.out.println("Местоположение: " + location);
        System.out.println("Количество аттракционов: " + attractions.length);

        System.out.println();

        if (attractions.length > 0) {
            System.out.println("СПИСОК АТТРАКЦИОНОВ:");
            System.out.println("====================");

            for (int i = 0; i < attractions.length; i++) {
                System.out.println("Аттракцион #" + (i + 1) + ":");
                attractions[i].displayAttractionInfo();
            }
        } else {
            System.out.println("В парке пока нет аттракционов.");
        }
    }
    public double calculateTotalCost() {
        double total = 0;
        for (Attraction attraction : attractions) {
            total += attraction.getPrice();
        }
        return total;
    }

}

