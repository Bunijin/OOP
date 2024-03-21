package lab8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ChessBoard b = new ChessBoard();
        Scanner input = new Scanner(System.in);
        b.setGame();
        String prompt;
        String destination;
        while (true) {
            String colours = (b.isWhiteTurn) ? "White's turn" : "Black's turn";
            System.out.println(colours + "\nWhat piece do you want to move? [name(freeMove) or position(move)]");
            prompt = input.nextLine();
            if (prompt.equals("exit"))
                break;
            System.out.println("Where do you want to move to?");
            destination = input.nextLine();
            if (destination.equals("exit"))
                break;
            if (Character.isDigit(prompt.toLowerCase().charAt(1))) {
                b.move(prompt, destination);
            } else {
                b.freeMove(prompt, destination);
            }
        }
        input.close();
    }
}
