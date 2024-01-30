package bird;

import java.util.ArrayList;

public class Behavior {

    private String name;
    private String gender;
    private int age;
    int birdWeight = 120;
    int totalFoodWeight = 0;
    ArrayList<String> consumedItems = new ArrayList<String>();
    ArrayList<Integer> foodWeights = new ArrayList<Integer>();

    public Behavior(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    void checkWeight() {
        if (totalFoodWeight > birdWeight) {
            System.out.println("Oh no! Seems like the bird ate too much!");
            eject();
        }
    }


    void speak() {
        System.out.println("My age is " + this.age);
    }

    void speak(String text) {
        System.out.println("\"" + text + "\"");
    }

    void eat(String foodName, int foodWeight) {
        System.out.println("\"" + this.name + "\" eat " + foodName + " " + foodWeight + " g");
        consumedItems.add(foodName);
        foodWeights.add(foodWeight);
        totalFoodWeight += foodWeight;
        System.out.println("Total food weight of \"" + this.name + "\" is " + totalFoodWeight + " g");
        checkWeight();
    }

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
        if(parent.gender.equals(null))  {
            return null;
        } else if (("M".equals(this.gender) && "F".equals(parent.gender))
                || ("F".equals(this.gender) && "M".equals(parent.gender))) {
            String left = this.name.substring(0, 1);
            String right = parent.name.substring(0, 1);
            char first = left.charAt(0);
            char second = right.charAt(0);
            System.out.println("\"" + this.name + "\" successfuly bred with \"" + parent.name + "\"");
            return String.valueOf(first) + String.valueOf(second);
        } else {
            System.out.println("Cannot breed with same gender.");
            return null;
        }
    }
    
    void details() {
        System.out.println("name : " + this.name + ", gender : " + this.gender + ", age : " + this.age
        + ", bird weight : " + this.birdWeight + " g, food weight : " + this.totalFoodWeight + " g");
    }
}
