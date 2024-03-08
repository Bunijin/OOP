package lab8;

public class Pawn extends Figure {

    public Pawn(String name, boolean isWhite, String position) {
        super(name, isWhite, position);
    }

    @Override
    public void move(String destination, ChessBoard board) {
        // Extract current and destination coordinates
        int currentX = this.position.charAt(0) - 'a';
        int currentY = 8 - Integer.parseInt(this.position.substring(1));
        int destX = destination.charAt(0) - 'a';
        int destY = 8 - Integer.parseInt(destination.substring(1));
        if (!checkValidMove(destination, destX, destY, board)) {
            return;
        }
        if (isValidMoveForPawn(destX, destY, currentX, currentY, isWhite, board)) {
            // Determine the direction of movement
            int directionX = Integer.compare(destX, currentX);
            int directionY = Integer.compare(destY, currentY);
            // Initialize variables for checking along the path
            int checkX = currentX + directionX;
            int checkY = currentY + directionY;
            // Check for obstructions along the path
            while (checkX != destX || checkY != destY) {
                if (board.board[checkY][checkX] != null) {
                    System.out.println("Cannot move! Path is obstructed by " + board.board[checkY][checkX].name);
                    return;
                }
                checkX += directionX;
                checkY += directionY;
            }
            // Setting board position
            board.board[currentY][currentX] = null;
            board.board[destY][destX] = this;
            this.position = destination;
            board.isWhiteTurn = !board.isWhiteTurn;

            if (board.board[destY][destX] == null) {
                System.out.println(this.name + " moved successfully.");
            } else if (board.board[destY][destX].isWhite != this.isWhite) {
                System.out.println(this.name + " has captured " + board.board[destY][destX].name);
            }
        } else {
            System.out.println("Invalid move for pawn!");
            return;
        }
    }

    private boolean isValidMoveForPawn(int destX, int destY, int currentX, int currentY, boolean isWhite,
            ChessBoard board) {
        if (!isWhite && destX == currentX && (destY - currentY == 2 && currentY == 1)) {
            return true;
        }
        if (isWhite && destX == currentX && (destY - currentY == -2 && currentY == 6)) {
            return true;
        }
        if (isWhite && destX == currentX && destY - currentY == -1) {
            return true;
        }
        if (!isWhite && destX == currentX && destY - currentY == 1) {
            return true;
        }
        if (isWhite && isOpponentPiece(board, destX, destY, currentX, currentY, -1)) {
            return true;
        }
        if (!isWhite && isOpponentPiece(board, destX, destY, currentX, currentY, 1)) {
            return true;
        }
        return false;
    }

    private boolean isOpponentPiece(ChessBoard board, int destX, int destY, int currentX, int currentY, int direction) {
        return board.board[destY][destX] != null && Math.abs(destX - currentX) == 1 && destY - currentY == direction;
    }
}
