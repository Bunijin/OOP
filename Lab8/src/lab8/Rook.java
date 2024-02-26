package lab8;

public class Rook extends Figure {

    public Rook(String name, char color, String position) {
        super(name, color, position);
    }

    @Override
    public void move(String destination, ChessBoard board) {
        // Extract current and destination coordinates
        int currentX = this.getPos().charAt(0) - 'a';
        int currentY = 8 - Integer.parseInt(this.getPos().substring(1));
        int destinationX = destination.charAt(0) - 'a';
        int destinationY = 8 - Integer.parseInt(destination.substring(1));

        // Check if the move is either horizontal or vertical
        if (Math.abs(currentX - destinationX) == 0 || Math.abs(currentY - destinationY) == 0) {
            // Determine the direction of movement
            int directionX = Integer.compare(destinationX, currentX);
            int directionY = Integer.compare(destinationY, currentY);

            // Initialize variables for checking along the path
            int checkX = currentX + directionX;
            int checkY = currentY + directionY;

            // Check for obstructions along the path
            while (checkX != destinationX || checkY != destinationY) {
                if (board.board[checkY][checkX] != null) {
                    System.out.println("Cannot move! Path is obstructed by " + board.board[checkY][checkX].getName());
                    return;
                }
                checkX += directionX;
                checkY += directionY;
            }

            // The path is clear, proceed with the move
            if (board.board[destinationY][destinationX] == null
                    || board.board[destinationY][destinationX].getColor() != this.getColor()) {
                if (board.board[destinationY][destinationX] != null) {
                    // Show if the piece has captured anything
                    System.out.println(this.getName() + " has captured " + board.board[destinationY][destinationX].getName());
                } else {
                    // There's no piece on this spot
                    System.out.println(this.getName() + " moved successfully.");
                }
                // Update the board and piece position
                board.board[currentY][currentX] = null;
                board.board[destinationY][destinationX] = this;
                this.setPos(destination);
            } else {
                System.out.println("Cannot move! Destination is occupied by a piece of the same color.");
            }
        } else {
            System.out.println("Invalid move for a Rook!");
        }
    }
}