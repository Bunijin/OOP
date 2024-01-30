package Hourglasses;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Display information about the hourglass and sand transfer
        System.out.println("The available side of an hourglass is [Side1, Side2, Side3, Side4] being [^, <, V, >] respectively.\nOnly Side1(if A have sand) and Side3(if B have sand) the sand will start to transfer.\n\nBy default, the hourglass starts at [Side1] and the sand starts transferring immediately.");
        Function h1 = new Function();
        System.out.print("Starting sand : ");
        h1.currentSandState();
        Scanner input = new Scanner(System.in);
        System.out.println();
        h1.sandFlow();
        String Rotation;
        // Main loop for user interaction
        do {
            System.out.println("_____________________________________________________________");
            h1.currentSandState();
            System.out.println("[1] Rotate 90 degrees to the right [2] Rotate 180 degrees to the right [3] Exit program");
            Rotation = input.nextLine();

            switch (Rotation) {
                case "1", "90":
                    h1.rotate90Right();
                    break;
                case "2", "180":
                    h1.rotate180Right();
                    break;
                case "3":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid command! Please try to input numbers 1, 2, 3, or numbers of degrees.");
                    break;
            }
        } while (!Rotation.equals("3"));

        input.close();
    }
}
