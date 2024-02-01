package bird;

import java.util.ArrayList;

public final class Bird {

    // Fields to represent the behavior of a bird
    private String name;
    private String gender;
    private int age;
    private final int birdWeight = 120;
    private int totalFoodWeight = 0;
    private ArrayList<String> consumedItems;
    private ArrayList<Integer> foodWeights;

    // Constructors to initialize the behavior with various parameters

    // Constructor with only name (random gender and default age)
    Bird(String name) {
        initializeLists();
        this.name = name;
        getRandomGender();
        getAge();
        printDetails(); // Print bird details after creation
    }

    // Constructor with name and gender (default age)
    Bird(String name, String gender) {
        initializeLists();
        this.name = name;
        this.gender = gender;
        getAge();
        printDetails(); // Print bird details after creation
    }

    // Constructor with name and age (random gender)
    Bird(String name, int age) {
        initializeLists();
        this.name = name;
        getRandomGender();
        this.age = age;
        printDetails(); // Print bird details after creation
    }

    // Constructor with name, gender, and age
    Bird(String name, String gender, int age) {
        initializeLists();
        this.name = name;
        this.gender = gender;
        this.age = age;
        printDetails(); // Print bird details after creation
    }

    // Method to initialize ArrayLists for consumedItems and foodWeights
    private void initializeLists() {
        this.consumedItems = new ArrayList<>();
        this.foodWeights = new ArrayList<>();
    }

    // Method to check if the total food weight exceeds the bird weight
    void checkWeight() {
        if (totalFoodWeight > birdWeight) {
            System.out.println("Oh no! Seems like the bird ate too much!");
            eject();
        }
    }

    // Method to print bird details if the name is not null
    void printDetails() {
        if (name != null) {
            System.out.println(birdDetails());
            System.out.println("-".repeat(40));
        }
    }

    // Method to make the bird speak its age
    void speak() {
        System.out.println("My age is " + this.age);
    }

    // Method to make the bird speak a custom text
    void speak(String text) {
        System.out.println("\"" + text + "\"");
    }

    // Method to simulate the bird eating a specific food with a given weight
    void eat(String foodName, int foodWeight) {
        System.out.println("\"" + this.name + "\" eat " + foodName + " " + foodWeight + " g");
        consumedItems.add(foodName);
        foodWeights.add(foodWeight);
        totalFoodWeight += foodWeight;
        System.out.println("Total food weight of \"" + this.name + "\" is " + totalFoodWeight + " g");
        checkWeight();
    }

    // Method to simulate the bird ejecting all consumed food
    void eject() {
        while (!consumedItems.isEmpty()) {
            consumedItems.remove(0);
            int foodWeight = foodWeights.remove(0);
            System.out.println(foodWeight + " g has been pooped out");
            // Update the total food weight
            totalFoodWeight -= foodWeight;
        }
        System.out.println("Remaining total food weight is " + totalFoodWeight + " g");
    }

    // Method to simulate the bird ejecting a specific food weight
    void eject(String release) {
        int foodWeight = 0;
        if (consumedItems.isEmpty()) {
            System.out.println("This bird hasn't eaten anything yet.");
        } else if (consumedItems.contains(release)) {
            for (int i = 0; i < consumedItems.size(); i++) {
                String foodName = consumedItems.get(i);
                if (foodName.equals(release)) {
                    foodWeight = foodWeights.get(i);
                    consumedItems.remove(i);
                    foodWeights.remove(i);
                    totalFoodWeight -= foodWeight;
                    break;
                }
            }
            System.out.println("Remaining total food weight is " + totalFoodWeight + " g");
        }
    }

    // Method to breed a new bird based on gender compatibility
    Bird breed(Bird parent) {
        System.out.println("\"" + this.name + "\" trying to breed with \"" + parent.name + "\"");
        if (parent.gender == null) {
            return null;
        } else if (("Male".equals(this.gender) && "Female".equals(parent.gender))
                || ("Female".equals(this.gender) && "Male".equals(parent.gender))) {
            String left = this.name.substring(0, 1);
            String right = parent.name.substring(0, 1);
            String babyName = String.valueOf(left.charAt(0)) + String.valueOf(right.charAt(0));
            System.out.println("\"" + this.name + "\" successfully bred with \"" + parent.name + "\"");
            System.out.println("-".repeat(40));
            return new Bird(babyName);
        } else {
            System.out.println("Cannot breed with the same gender.");
            System.out.println("-".repeat(40));
            return null;
        }
    }

    // Method to get a string representation of bird details
    String birdDetails() {
        return "name: " + this.name + ", gender: " + this.gender + ", age: " + this.age
                + ", bird weight: " + this.birdWeight + " g, food weight: " + this.totalFoodWeight + " g";
    }

    // Method to randomly assign a gender
    void getRandomGender() {
        this.gender = Math.random() < 0.5 ? "Male" : "Female";
    }

    // Method to initialize age to 1
    void getAge() {
        this.age = 1;
    }
}
