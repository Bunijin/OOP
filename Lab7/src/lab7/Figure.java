package lab7;

public class Figure {

    private final String name;
    private final char color;
    private char posX;
    private int posY;

    public Figure(String name, char color, char posX, int posY) {
        this.name = name;
        this.color = color;
        this.posX = posX;
        this.posY = posY;
    }

    public String getName() {
        return name;
    }

    public char getColor() {
        return color;
    }

    public String getPos() {
        return String.valueOf(this.posX) + this.posY;
    }

    // Info for display on the board
    public String getInfo() {
        String formattedName = this.name.equalsIgnoreCase("knight") ? "Kn" : String.valueOf(this.name.charAt(0));
        return formattedName + this.color + this.posX + this.posY;
    }

    public void freeMove(char posX, int posY, ChessBoard board) {
        int arrayPosX = posX - 'a'; // Change from char to int [a = 0, b = 1, c = 2 , ... , h = 7] 
        int arrayPosY = 8 - posY;   // Inverting number

        // Check if this spot is empty or isn't the same color as this piece
        if (board.board[arrayPosY][arrayPosX] == null || board.board[arrayPosY][arrayPosX].getColor() != this.color) {

            if (board.board[arrayPosY][arrayPosX] != null) {
                // Show if the piece has captured anything
                System.out.println(this.name + " has captured " + board.board[arrayPosY][arrayPosX].getName());
            } else {
                // There's no piece on this spot
                System.out.println(this.name + " moved successfully.");
            }

            board.board[8 - this.posY][this.posX - 'a'] = null;
            board.board[arrayPosY][arrayPosX] = this;
            this.posX = posX;
            this.posY = posY;
        } else {
            System.out.println("Cannot move! Due to the same color!");
        }
    }
}