package lab6;

public final class Board {

    Figure[] figures;  
    String[] board;     

    public Board() {
        this.board = new String[10];
        this.figures = new Figure[2];
        setBoard();
    }

    // Method to initialize the board and place initial figures
    public void setBoard() {
        // Initialize the board with "__" for each cell
        for (int i = 0; i < board.length; i++) {
            board[i] = "__";
        }
        
        // Create and place initial figures on the board
        figures[0] = new Figure("Trace", 1);
        figures[1] = new Figure("David", 2);
        for (Figure figure : figures) {
            int position = figure.getPosition();
            // Ensure the position is valid before placing the figure on the board
            if (position >= 1 && position <= board.length) {
                board[position - 1] = figure.getName().substring(0, Math.min(figure.getName().length(), 2));
            }
        }
        displayBoard();
    }

    // Move a figure to the specified destination on the board
    public void moveFigure(String name, int destination) {
        for (Figure figure : figures) {
            if (figure.getName().equals(name)) {
                int currentPosition = figure.getPosition();
                // Check for a valid move before updating the board
                if (1 <= destination && destination <= 10 && currentPosition != destination && board[destination - 1].equals("__")) {
                    figure.setPosition(destination);
                    board[--currentPosition] = "__";
                    board[--destination] = figure.getName().substring(0, Math.min(name.length(), 2));
                    displayBoard();
                    return;
                } else {
                    System.out.println("Invalid move. Please try again.");
                    return;
                }
            }
        }
        System.out.println("Player not found.");
    }

    // Display the current state of the board
    public void displayBoard() {
        System.out.println("Current board: ");
        for (String cell : board) {
            System.out.print(cell + " | ");
        }
        System.out.println("\n" + "-".repeat(49));
    }
    
}
