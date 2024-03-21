package lab8;

public final class ChessBoard {

    public final Figure[][] board;
    public boolean isWhiteTurn = true;

    public ChessBoard() {
        this.board = new Figure[8][8];
        for (Figure[] boardX : board) {
            for (int j = 0; j < boardX.length; j++) {
                boardX[j] = null;
            }
        }
    }

    public void setGame() {
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("Pawn", false, (char) ('a' + i) + "7");
            board[6][i] = new Pawn("Pawn", true, (char) ('a' + i) + "2");
        }
        board[0][0] = new Rook("Rook", false, "a8");
        board[0][7] = new Rook("Rook", false, "h8");
        board[7][0] = new Rook("Rook", true, "a1");
        board[7][7] = new Rook("Rook", true, "h1");
        board[0][1] = new Knight("Knight", false, "b8");
        board[0][6] = new Knight("Knight", false, "g8");
        board[7][1] = new Knight("Knight", true, "b1");
        board[7][6] = new Knight("Knight", true, "g1");
        board[0][2] = new Bishop("Bishop", false, "c8");
        board[0][5] = new Bishop("Bishop", false, "f8");
        board[7][2] = new Bishop("Bishop", true, "c1");
        board[7][5] = new Bishop("Bishop", true, "f1");
        board[0][3] = new Queen("Queen", false, "d8");
        board[7][3] = new Queen("Queen", true, "d1");
        board[0][4] = new King("King", false, "e8");
        board[7][4] = new King("King", true, "e1");
        display();
    }

    public void display() {
        System.out.println("\t a\t b\t c\t d\t e\t f\t g\t h\t ");
        System.out.println("  " + "=".repeat(71));
        for (int row = 0; row < board.length; row++) {
            System.out.print((board.length - row) + " |\t");
            for (int col = 0; col < board.length; col++) {
                if(board[row][col] != null) System.out.print(board[row][col].getInfo() + "\t");
                else System.out.print(" --\t");
            }
            System.out.println("|\n");
        }
        System.out.println("  " + "=".repeat(71));
    }

    public void freeMove(String name, String destination) {
        for (Figure[] boardX : board) {
            for (Figure boardYX : boardX) {
                if (boardYX != null && boardYX.name.toLowerCase().equals(name)) {
                    boardYX.freeMove(destination, this);
                    display();
                    return;
                }
            }
        }
    }

    public void move(String currentPosition, String destination) {
        for (Figure[] boardX : board) {
            for (Figure boardYX : boardX) {
                if (boardYX != null && boardYX.position.equals(currentPosition)) {
                    boardYX.move(destination, this);
                    display();
                    return;
                }
            }
        }
        System.out.println("There's no figure on [" + currentPosition + "]");
    }
}
