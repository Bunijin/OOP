package lab8;

public class Figure {

    protected final String name;
    protected final boolean isWhite;
    protected String position;

    public Figure(String name, boolean isWhite, String position) {
        this.name = name;
        this.isWhite = isWhite;
        this.position = position;
    }

    public String getInfo() {
        String color = (isWhite) ? "W" : "B";
        String formattedName = this.name.equalsIgnoreCase("knight") ? "N" : String.valueOf(this.name.charAt(0));
        return color + formattedName + this.position;
    }

    public void move(String destination, ChessBoard board) {
        freeMove(destination, board);
    }

    public void freeMove(String destination, ChessBoard board) {
        int currentX = this.position.charAt(0) - 'a';
        int currentY = 8 - Integer.parseInt(this.position.substring(1));
        int destX = destination.charAt(0) - 'a';
        int destY = 8 - Integer.parseInt(destination.substring(1));

        if (0 > destX || destX > 7 || 0 > destY || destY > 7) {
            System.out.println("The destination is out of range.");
        } else if (this.position.equals(destination)) {
            System.out.println("Cannot move to the same position!");
        } else {
            if (board.board[destY][destX] != null) {
                System.out.println(this.name + " has captured " + board.board[destY][destX].name);
            } else {
                System.out.println(this.name + " moved successfully.");
            }
            board.board[currentY][currentX] = null;
            board.board[destY][destX] = this;
            this.position = destination;
        }
    }

    boolean checkValidMove(String destination, int destX, int destY, ChessBoard board) {
        if (0 > destX || destX > 7 || 0 > destY || destY > 7) {
            System.out.println("The destination is out of range.");
            return true;
        } else if (this.position.equals(destination)) {
            System.out.println("Cannot move to the same position!");
            return true;
        } else if (board.board[destY][destX] != null && board.board[destY][destX].isWhite == this.isWhite) {
            System.out.println("Cannot move! Destination is occupied by a piece of the same color.");
            return true;
        } else if ((!board.isWhiteTurn && isWhite) || (board.isWhiteTurn && !isWhite)) {
            String turn = (board.isWhiteTurn) ? "White " : "Black ";
            System.out.println(turn + "turns to move!");
            return true;
        }
        return false;
    }
}
