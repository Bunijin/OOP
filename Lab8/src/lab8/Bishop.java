package lab8;

public class Bishop extends Figure {

    public Bishop(String name, boolean isWhite, String position) {
        super(name, isWhite, position);
    }

    @Override
    public void move(String destination, ChessBoard board) {
        // Extract current and destination coordinates
        int currentX = this.position.charAt(0) - 'a';
        int currentY = 8 - Integer.parseInt(this.position.substring(1));
        int destinationX = destination.charAt(0) - 'a';
        int destinationY = 8 - Integer.parseInt(destination.substring(1));

        if (0 > destinationX || destinationX > 7 || 0 > destinationY || destinationY > 7) {
            System.out.println("The destination is out of range.");
            return;
        } else if(this.position == destination) {
            System.out.println("Cannot move to the same position!");
            return;
        } else if (board.board[destinationY][destinationX] != null
                && board.board[destinationY][destinationX].isWhite == this.isWhite) {
            System.out.println("Cannot move! Destination is occupied by a piece of the same color.");
            return;
        }
        // Check if the move is along diagonal path
        if (Math.abs(currentX - destinationX) == Math.abs(currentY - destinationY)) {
            // Determine the direction of movement
            int directionX = Integer.compare(destinationX, currentX);
            int directionY = Integer.compare(destinationY, currentY);
            // Initialize variables for checking along the path
            int checkX = currentX + directionX;
            int checkY = currentY + directionY;
            // Check for obstructions along the path
            while (checkX != destinationX && checkY != destinationY) {
                if (board.board[checkY][checkX] != null) {
                    System.out.println("Cannot move! Path is obstructed by " + board.board[checkY][checkX].name);
                    return;
                }
                checkX += directionX;
                checkY += directionY;
            }
            // Setting board position
            board.board[currentY][currentX] = null;
            board.board[destinationY][destinationX] = this;
            this.position = destination;

            if (board.board[destinationY][destinationX] == null) {
                System.out.println(this.name + " moved successfully.");
            } else if (board.board[destinationY][destinationX].isWhite != this.isWhite) {
                System.out.println(this.name + " has captured " + board.board[destinationY][destinationX].name);
            }
        } else {
            System.out.println("Invalid move for bishop!");
            return;
        }
    }
}
