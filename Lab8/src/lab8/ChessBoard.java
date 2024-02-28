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

    public void create(String name, boolean isWhite, String position) {
        int arrayPosX = position.charAt(0) - 'a';
        int arrayPosY = 8 - Integer.parseInt(position.substring(1));
        switch (name.toLowerCase()) {
            case "pawn"     -> {board[arrayPosY][arrayPosX] = new Pawn  ("Pawn"  , isWhite, position);}
            case "bishop"   -> {board[arrayPosY][arrayPosX] = new Bishop("Bishop", isWhite, position);}
            case "rook"     -> {board[arrayPosY][arrayPosX] = new Rook  ("Rook"  , isWhite, position);}
            case "knight"   -> {board[arrayPosY][arrayPosX] = new Knight("Knight", isWhite, position);}
            case "king"     -> {board[arrayPosY][arrayPosX] = new King  ("King"  , isWhite, position);}
            case "queen"    -> {board[arrayPosY][arrayPosX] = new Queen ("Queen" , isWhite, position);}
            default         -> {board[arrayPosY][arrayPosX] = new Figure("Figure", isWhite, position);}
        }
        System.out.println(board[arrayPosY][arrayPosX].name + " has been created on " + board[arrayPosY][arrayPosX].position);
    }

    public void freeMove(String name, String destination) {
        boolean found = false;
        // Check for every spot until finding the same name
        for (Figure[] boardX : board) {
            for (Figure boardYX : boardX) {
                if (boardYX != null && boardYX.name.equals(name)) {
                    // Move the piece position
                    found = true;
                    boardYX.freeMove(destination, this);
                    return;
                }
            }
        }
        if(!found)  {
            System.out.println("There's no figure name [" + name + "] on the board.");
        }
    }

    public void move(String currentPosition, String destination)   {
        boolean found = false;
        // Check for every spot until finding the same position
        for (Figure[] boardX : board) {
            for (Figure boardYX : boardX) {
                if (boardYX != null && boardYX.position.equals(currentPosition)) {
                    // Move the piece position
                    found = true;
                    boardYX.move(destination, this);
                    return;
                }
            }
        }
        if(!found)  {
            System.out.println("There's no figure on [" + currentPosition + "]");
        }
    }
}
