package lab6;

public final class Board {

    Figure[] figures;   // pieces on board
    String[] board;     // position of a board

    public Board() {
        this.board = new String[10];
        this.figures = new Figure[2];
        setBoard();
    }

    public void setBoard() {
        // set as empty as default
        for (int i = 0; i < board.length; i++) {
            board[i] = "__";
        }
        // create 2 figures
        figures[0] = new Figure("Trace", 1);
        figures[1] = new Figure("David", 2);
        // get figures position
        for (Figure figure : figures) {
            int position = figure.getPosition();
            if (position >= 1 && position <= board.length) {
                // store the first 2 characters of a name into board
                board[position - 1] = figure.getName().substring(0, Math.min(figure.getName().length(), 2));
            }
        }
        displayBoard();
    }

    public void moveFigure(String name, int destination) {
        // get figures position
        for (Figure figure : figures) {
            // check for figures name
            if (figure.getName().equals(name)) {
                int currentPosition = figure.getPosition();
                // check if the destination is valid in 1-10 and is an empty spot
                if (1 <= destination && destination <= 10 && currentPosition != destination && board[destination - 1] == "__") {
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

    public void displayBoard() {
        System.out.println("Current board: ");
        for (String board1 : board) {
            System.out.print(board1 + " | ");
        }
        System.out.println("\n" + "-".repeat(49));
    }

}