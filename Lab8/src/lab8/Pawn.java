package lab8;

import java.util.Scanner;

public class Pawn extends Figure {

    public Pawn(String name, boolean isWhite, String position) {
        super(name, isWhite, position);
    }

    @Override
    public void move(String destination, ChessBoard board) {
        int currentX = this.position.charAt(0) - 'a';
        int currentY = 8 - Integer.parseInt(this.position.substring(1));
        int destX = destination.charAt(0) - 'a';
        int destY = 8 - Integer.parseInt(destination.substring(1));

        if (checkValidMove(destination, destX, destY, board)) {
            return;
        }

        if (isValidMoveForPawn(destX, destY, currentX, currentY, isWhite, board)) {
            int directionX = Integer.compare(destX, currentX);
            int directionY = Integer.compare(destY, currentY);
            int checkX = currentX + directionX;
            int checkY = currentY + directionY;

            while (checkX != destX || checkY != destY) {
                if (board.board[checkY][checkX] != null) {
                    System.out.println("Cannot move! Path is obstructed by " + board.board[checkY][checkX].name);
                    return;
                }
                checkX += directionX;
                checkY += directionY;
            }
            board.board[currentY][currentX] = null;

            if (0 < destY && destY < 7) {
                board.board[destY][destX] = this;
            } else {
                System.out.println("Pawn is being promoted! Knight, Bishop, Rook, or Queen?");
                Scanner input = new Scanner(System.in);
                boolean created = false;
                String txt;

                while (!created) {
                    txt = input.nextLine();
                    created = true;

                    switch (txt.toLowerCase()) {
                        case "knight":
                            board.board[destY][destX] = new Knight("Knight", this.isWhite, this.position);
                            break;
                        case "bishop":
                            board.board[destY][destX] = new Bishop("Bishop", this.isWhite, this.position);
                            break;
                        case "rook":
                            board.board[destY][destX] = new Rook("Rook", this.isWhite, this.position);
                            break;
                        case "queen":
                            board.board[destY][destX] = new Queen("Queen", this.isWhite, this.position);
                            break;
                        default:
                            System.out.println("Invalid input! Please try again.");
                            created = false;
                            break;
                    }
                }
                System.out.println("Successfully promoted to " + board.board[destY][destX].name);
                input.close();
            }
            this.position = destination;
            board.isWhiteTurn = !board.isWhiteTurn;

            if (board.board[destY][destX] == null) {
                System.out.println(this.name + " moved successfully.");
            } else if (board.board[destY][destX].isWhite != this.isWhite) {
                System.out.println(this.name + " has captured " + board.board[destY][destX].name);
            }
        } else {
            System.out.println("Invalid move for pawn!");
        }
    }

    private boolean isValidMoveForPawn(int destX, int destY, int currentX, int currentY, boolean isWhite, ChessBoard board) {
        if (isWhite && destX == currentX && destY - currentY == -1) {
            return true;
        }
        if (!isWhite && destX == currentX && destY - currentY == 1) {
            return true;
        }
        if (isWhite && destX == currentX && (destY - currentY == -2 && currentY == 6)) {
            return true;
        }
        if (!isWhite && destX == currentX && (destY - currentY == 2 && currentY == 1)) {
            return true;
        }
        if (isWhite && isOpponentPiece(board, destX, destY, currentX, currentY, -1)) {
            return true;
        }
        return !isWhite && isOpponentPiece(board, destX, destY, currentX, currentY, 1);
    }

    private boolean isOpponentPiece(ChessBoard board, int destX, int destY, int currentX, int currentY, int direction) {
        return board.board[destY][destX] != null && Math.abs(destX - currentX) == 1 && destY - currentY == direction;
    }
}
