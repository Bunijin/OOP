package bird;

import java.util.ArrayList;

public class MynaBird {

    String empty_string = "";
    String everything = "all";
    String name = "Nokkuntong";
    int age = 4;
    int birdWeight = 120;
    int totalFoodWeight = 0;

    // ArrayLists to store food eat and the food weights
    ArrayList<String> consumedItems = new ArrayList<String>();
    ArrayList<Integer> foodWeights = new ArrayList<Integer>();

    void say(String speak) {
        if (!speak.equals(empty_string)) {
            System.out.printf("\"%s\" said %s\n", speak, name);
        } else {
            System.out.printf("\"my age is %d\" said %s\n", age, name);
        }
    }

    void eat(String foodName, int foodWeight) {
        System.out.printf("%s %d g\n", foodName, foodWeight);

        // Add  food eat and weight to their ArrayLists
        consumedItems.add(foodName);
        foodWeights.add(foodWeight);

        // Update the total food weight
        totalFoodWeight += foodWeight;

        System.out.printf("Total food weight is %d g", totalFoodWeight);

        // Check if the total food weight exceeds the bird's weight limit
        if (totalFoodWeight > birdWeight) {
            System.out.println();
            System.out.println("Oh no! Seems like the bird ate too much!");
            eject(everything);
        }

        System.out.println();
    }

    void eject(String release) {
        int foodWeight = 0;

        if (consumedItems.isEmpty()) {
            // If there's nothing to poop out
        } else if (consumedItems.contains(release)) {
            // If the release item is found
            for (int i = 0; i < consumedItems.size(); i++) {
                String foodName = consumedItems.get(i);
                if (foodName.equals(release)) {
                    foodWeight = foodWeights.get(i);
                    //Remove from ArrayList
                    consumedItems.remove(i);
                    foodWeights.remove(i);
                    // Update the total food weight
                    totalFoodWeight -= foodWeight;
                    // Stop the loop
                    break;
                }
            }
            System.out.printf("Total food weight is %d g\n", totalFoodWeight);
            System.out.printf("%s has been pooped out!\n", release);
        } else if (release.equals(everything)) {
            // If releasing everything, poop out all items
            while (!consumedItems.isEmpty()) {
                String foodName = consumedItems.remove(0);
                foodWeight = foodWeights.remove(0);
                System.out.printf("%s %d g has been pooped out!\n", foodName, foodWeight);
                // Update the total food weight
                totalFoodWeight -= foodWeight;
            }
            System.out.printf("Remaining total food weight is %d g", totalFoodWeight);
        }
    }
}