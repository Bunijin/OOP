package glass;

import java.util.Scanner;

public class Main {

    static void menues() {
        System.out.println("=".repeat(40));
        System.out.println(
                "[0] Exit Program\n[1] Fill up Water   [2] Pour out Water\n[3] Transfer Water  [4] Show Water");
        System.out.println("=".repeat(40));
    }

    static void filling(Glass glass, String text, Scanner input) {
        System.out.println(text);
        String number = input.nextLine();
        if (number.equals("all")) {
            glass.fillWater();
        } else {
            try {
                int add = Integer.parseInt(number);
                glass.fillWater(add);
            } catch (NumberFormatException e) {
                System.out.println("Please input a number");
            }
        }
    }

    static void pouring(Glass glass, String text, Scanner input) {
        System.out.println(text);
        String number = input.nextLine();
        if (number.equals("all")) {
            glass.pourWater();
        } else {
            try {
                int subtract = Integer.parseInt(number);
                glass.pourWater(subtract);
            } catch (NumberFormatException e) {
                System.out.println("Please input a number");
            }
        }
    }

    static void transfering(Glass start, Glass destination, String text, Scanner input) {
        System.out.println(text);
        String number = input.nextLine();
        if (number.equals("all")) {
            start.pourWaterTo(destination);
        } else {
            try {
                int amount = Integer.parseInt(number);
                start.pourWaterTo(destination, amount);
            } catch (NumberFormatException e) {
                System.out.println("Please input a number");
            }
        }
    }

    public static void main(String[] args) {
        Glass g1 = new Glass();
        Glass g2 = new Glass();
        Scanner input = new Scanner(System.in);
        String option;
        do {
            menues();
            option = input.nextLine();
            switch (option) {
                case "0" ->
                    System.out.println("Exitting...");
                case "1" -> {
                    System.out.println("Which one you want to fill? (1 or 2 or both)");
                    String option_case = input.nextLine();
                    switch (option_case) {
                        case "1" ->
                            filling(g1,
                                    "How much do you want to fill for 1st one? (1 - " + g1.maxWater() + " ml or all)",
                                    input);
                        case "2" ->
                            filling(g2,
                                    "How much do you want to fill for 2nd one? (1 - " + g2.maxWater() + " ml or all)",
                                    input);
                        case "both" -> {
                            filling(g1,
                                    "How much do you want to fill for 1st one? (1 - " + g1.maxWater() + " ml or all)",
                                    input);
                            filling(g2,
                                    "How much do you want to fill for 2nd one? (1 - " + g2.maxWater() + " ml or all)",
                                    input);
                        }
                        default ->
                            System.out.println("Invalid Input");
                    }
                }
                case "2" -> {
                    System.out.println("Which one you want to pour? (1 or 2 or both)");
                    String option_case = input.nextLine();
                    switch (option_case) {
                        case "1" ->
                            pouring(g1,
                                    "How much do you want to pour for 1st one? (1 - " + g1.currentWater()
                                    + " ml or all)",
                                    input);
                        case "2" ->
                            pouring(g2,
                                    "How much do you want to pour for 2nd one? (1 - " + g1.currentWater()
                                    + " ml or all)",
                                    input);
                        case "both" -> {
                            pouring(g1,
                                    "How much do you want to pour for 1st one? (1 - " + g1.currentWater()
                                    + " ml or all)",
                                    input);
                            pouring(g2,
                                    "How much do you want to pour for 2nd one? (1 - " + g1.currentWater()
                                    + " ml or all)",
                                    input);
                        }
                        default ->
                            System.out.println("Invalid Input");
                    }

                }
                case "3" -> {
                    System.out.println("Which glass you want to transfer from? (1 or 2)");
                    String option_case = input.nextLine();
                    switch (option_case) {
                        case "1" ->
                            transfering(g1, g2, "How much do you want to transfer from 1st to 2nd? (1 - "
                                    + g1.currentWater() + " ml or all)", input);

                        case "2" ->
                            transfering(g2, g1, "How much do you want to transfer from 2nd to 1st? (1 - "
                                    + g1.currentWater() + " ml or all)", input);
                        default ->
                            System.out.println("Invalid Input");
                    }
                }
                case "4" ->
                    System.out.println(
                            "1st Glass: " + g1.currentWater() + " ml and 2nd Glass: " + g2.currentWater() + " ml");
                default ->
                    System.out.println("Invalid input please try again.");
            }
        } while (!option.equals("0"));
        input.close();
    }
}
