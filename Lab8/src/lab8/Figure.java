package lab8;

import java.util.ArrayList;

public class Figure {

    protected final String name;
    protected final boolean isWhite;
    protected String position;
    ArrayList<String> movableList = new ArrayList<String>();

    public Figure(String name, boolean isWhite, String position) {
        this.name = name;
        this.isWhite = isWhite;
        this.position = position;
    }

    // Info for display on the board
    public String getInfo() {
        String color = (isWhite) ? "W" : "B";
        String formattedName = this.name.equalsIgnoreCase("knight") ? "Kn" : String.valueOf(this.name.charAt(0));
        return  color + formattedName + this.position;
    }

    public void move(String position, ChessBoard board) {
    }

    void updateMovableList(ChessBoard board) {
        this.movableList.clear();
        for (Figure[] boardX : board.board) {
            for (Figure boardYX : boardX) {
                if(boardYX == null || boardYX.isWhite != this.isWhite) {
                    //this.movableList.add(this.position);
                }
            }
        }
    }

    public void freeMove(String destination, ChessBoard board) {

        int currentX = this.position.charAt(0) - 'a';
        int currentY = 8 - Integer.parseInt(this.position.substring(1));
        int destinationX = destination.charAt(0) - 'a';
        int destinationY = 8 - Integer.parseInt(destination.substring(1));

        // Check if this spot is empty or isn't the same color as this piece
        if (board.board[destinationY][destinationX] == null
                || board.board[destinationY][destinationX].isWhite != this.isWhite) {

            if (board.board[destinationY][destinationX] != null) {
                // Show if the piece has captured anything
                System.out.println(this.name + " has captured " + board.board[destinationY][destinationX].name);
            } else {
                // There's no piece on this spot
                System.out.println(this.name + " moved successfully.");
            }

            board.board[currentY][currentX] = null;
            board.board[destinationY][destinationX] = this;
            this.position = destination;
        } else {
            System.out.println("Cannot move! Due to the same color!");
        }
    }

}
