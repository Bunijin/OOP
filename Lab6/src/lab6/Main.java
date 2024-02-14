package lab6;

public class Main {

    public static void main(String[] args) {
        Board game = new Board();
        game.moveFigure("Trace", 3);    // move to 3rd spot
        game.moveFigure("Trace", 7);    // move to 7th spot
        game.moveFigure("David", 5);    // move to 5th spot
        game.moveFigure("David", 7);    // move to 7th spot whereas is occupied by another Figure
        game.moveFigure("Trace", 15);   // move to unexisting spot
    }
    
}