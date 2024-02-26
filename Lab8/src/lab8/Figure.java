package lab8;

public class Figure {

    private final String name;
    private final char color;
    private String position;

    public Figure(String name, char color, String position) {
        this.name = name;
        this.color = color;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public char getColor() {
        return this.color;
    }

    public String getPos() {
        return this.position;
    }
    
    public void setPos(String position) {
        this.position = position;
    }

    // Info for display on the board
    public String getInfo() {
        String formattedName = this.name.equalsIgnoreCase("knight") ? "Kn" : String.valueOf(this.name.charAt(0));
        return formattedName + this.color + this.position;
    }

    public void move(String position, ChessBoard board) {
    }

    public void freeMove(String destination, ChessBoard board) {

        int currentX = this.position.charAt(0) - 'a';
        int currentY = 8 - Integer.parseInt(this.position.substring(1));
        int destinationX = destination.charAt(0) - 'a'; 
        int destinationY = 8 - Integer.parseInt(destination.substring(1));

        // Check if this spot is empty or isn't the same color as this piece
        if (board.board[destinationY][destinationX] == null || board.board[destinationY][destinationX].getColor() != this.color) {

            if (board.board[destinationY][destinationX] != null) {
                // Show if the piece has captured anything
                System.out.println(this.name + " has captured " + board.board[destinationY][destinationX].getName());
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
