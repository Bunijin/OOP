package bird;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        MynaBird b1 = new MynaBird();
        Scanner input = new Scanner(System.in);
        String action;

        do {
            // Display menu options
            System.out.println("===============================================");
            System.out.println("What do you want the bird to do?");
            System.out.println("[1] Say    [2] Eat    [3] Defecate    [4] Exit");
            action = input.nextLine();

            switch (action) {
                case "1" -> {
                    // Option to make the bird say something
                    System.out.println("What do you want this bird to say?");
                    Scanner scentence = new Scanner(System.in);
                    String speak = scentence.nextLine();
                    b1.say(speak);
                }
                case "2" -> {
                    // Option to make the bird eat
                    System.out.println("How many types of food did the bird eat?");
                    int numFoodTypes;
                    while (true) {
                        try {
                            numFoodTypes = input.nextInt();
                            input.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input for food type. Please enter a valid number.");
                            input.nextLine();
                        }
                    }

                    String foodNameInput;
                    int foodWeightInput;

                    for (int i = 0; i < numFoodTypes; i++) {
                        System.out.println("Enter food name: ");
                        foodNameInput = input.nextLine();

                        System.out.println("Enter food weight (grams): ");
                        while (true) {
                            try {
                                foodWeightInput = input.nextInt();
                                input.nextLine();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input for food weight. Please enter a valid number.");
                                input.nextLine();
                            }
                        }
                        b1.eat(foodNameInput, foodWeightInput);
                    }
                }
                case "3" -> {
                    // Option to make the bird poop
                    if (!b1.consumedItems.isEmpty()) {
                        System.out.println("What is this bird going to poop out?");
                        for (String foodName : b1.consumedItems) {
                            System.out.printf("%s ", foodName);
                        }
                        System.out.println();
                        String release = input.nextLine();
                        b1.eject(release);
                    } else {
                        System.out.println("The bird has nothing to poop out.");
                    }
                }
                case "4" -> {
                    // Option to exit the program
                    System.out.println("Exiting...");
                }
                default -> {
                    // When user input invalid case
                    System.out.println("Invalid action. We only accept numbers 1, 2, 3, 4. Please try again.");
                }
            }
        } while (!action.equals("4"));
        // Stop scanner
        input.close();
    }
}