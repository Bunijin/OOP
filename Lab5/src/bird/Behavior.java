package bird;

import java.util.ArrayList;

public class Behavior {

    // Fields to represent the behavior of a bird
    private String name;
    private String gender;
    private int age;
    private int birdWeight = 120;
    private int totalFoodWeight = 0;
    private ArrayList<String> consumedItems = new ArrayList<String>();
    private ArrayList<Integer> foodWeights = new ArrayList<Integer>();

    // Constructor to initialize the behavior with a name, gender, and age
    public Behavior(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    // Method to check if the total food weight exceeds the bird weight
    void checkWeight() {
        if (totalFoodWeight > birdWeight) {
            System.out.println("Oh no! Seems like the bird ate too much!");
            eject();
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
            String foodName = consumedItems.remove(0);
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
            System.out.println("This bird haven't eaten anything yet.");
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

    String breed(Behavior parent) {
        if(parent.gender == null)  {
            return null;
        } else if (("Male".equals(this.gender) && "Female".equals(parent.gender))
                || ("Female".equals(this.gender) && "Male".equals(parent.gender))) {
            String left = this.name.substring(0, 1);
            String right = parent.name.substring(0, 1);
            char first = left.charAt(0);
            char second = right.charAt(0);
            System.out.println("\"" + this.name + "\" successfully bred with \"" + parent.name + "\"");
            return String.valueOf(first) + String.valueOf(second);
        } else {
            System.out.println("Cannot breed with the same gender.");
            return null;
        }
    }

    void birdDetails() {
        System.out.println("name: " + this.name + ", gender: " + this.gender + ", age: " + this.age
        + ", bird weight: " + this.birdWeight + " g, food weight: " + this.totalFoodWeight + " g");
    }
}