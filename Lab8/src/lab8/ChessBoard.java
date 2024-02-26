package lab8;

public final class ChessBoard {

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

    public void create(String name, char color, String position) {
        int arrayPosX = position.charAt(0) - 'a';
        int arrayPosY = 8 - Integer.parseInt(position.substring(1));
        switch (name.toLowerCase()) {
            case "pawn"     -> {board[arrayPosY][arrayPosX] = new Pawn("Pawn", color, position);    }
            case "bishop"   -> {board[arrayPosY][arrayPosX] = new Bishop("Bishop", color, position);}
            case "rook"     -> {board[arrayPosY][arrayPosX] = new Rook("Rook", color, position);    }
            case "knight"   -> {board[arrayPosY][arrayPosX] = new Knight("Knight", color, position);}
            case "king"     -> {board[arrayPosY][arrayPosX] = new King("King", color, position);    }
            case "queen"    -> {board[arrayPosY][arrayPosX] = new Queen("Queen", color, position);  }
            default         -> {board[arrayPosY][arrayPosX] = new Figure("Figure", color, position);}
        }
        System.out.println(board[arrayPosY][arrayPosX].getName() + " has been created on " + board[arrayPosY][arrayPosX].getPos());
        display();
    }

    public void freeMove(String name, String destination) {
        // Check for every spot until finding the same name
        for (Figure[] boardX : board) {
            for (Figure boardYX : boardX) {
                if (boardYX != null && boardYX.getName().equals(name)) {
                    // Move the piece position
                    boardYX.freeMove(destination, this);
                    display();
                    return;
                }
            }
        }
    }

    public void move(String currentPosition, String destination)   {
        // Check for every spot until finding the same position
        for (Figure[] boardX : board) {
            for (Figure boardYX : boardX) {
                if (boardYX != null && boardYX.getPos().equals(currentPosition)) {
                    // Move the piece position
                    boardYX.move(destination, this);
                    display();
                    return;
                }
            }
        }
    }
}
