package lab7;

public class ChessBoard {

    public final Figure[][] board;

    public ChessBoard() {
        this.board = new Figure[8][8];

        // Set all spots to null
        for (Figure[] boardX : board) {
            for (int j = 0; j < boardX.length; j++) {
                boardX[j] = null;
            }
        }

        display();
    }

    public void display() {
        int num = 8;
        System.out.println("\t a\t b\t c\t d\t e\t f\t g\t h\t ");
        System.out.println("  " + "=".repeat(71));

        for (Figure[] boardX : board) {
            System.out.print(num-- + " |\t");

            for (int j = 0; j < boardX.length; j++) {
                if (boardX[j] != null) {
                    System.out.print(boardX[j].getInfo() + "\t");
                } else {
                    System.out.print("___" + "\t");
                }

                if (j == 7) {
                    System.out.print("|\n");
                }
            }
        }

        System.out.println("  " + "=".repeat(71));
    }

    public void create(String name, char color, char posX, int posY) {
        int arrayPosX = posX - 'a'; // Change from char to int [a = 0, b = 1, c = 2 , ... , h = 7] 
        int arrayPosY = 8 - posY;   // Inverting number
        board[arrayPosY][arrayPosX] = new Figure(name, color, posX, posY);
        System.out.println(board[arrayPosY][arrayPosX].getName() + " has been created on " + board[arrayPosY][arrayPosX].getPos());
        display();
    }

    public void freeMove(String name, char posX, int posY) {
        // Check for every spot until finding the same name
        for (Figure[] boardX : board) {
            for (Figure boardYX : boardX) {
                if (boardYX != null && boardYX.getName().equals(name)) {
                    // Move the piece position
                    boardYX.freeMove(posX, posY, this);
                    display();
                    return;
                }
            }
        }
    }
}