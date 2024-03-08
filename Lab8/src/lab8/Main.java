package lab8;

public class Main {

    public static void main(String[] args) {
        ChessBoard b = new ChessBoard();
        b.setGame();
        b.display();
        b.display();
        b.move("e2","e4");
        b.move("e7","e5");
        b.move("g1","f3");
        b.move("b8","c6");
        b.move("f1","c4");
        b.move("g8","f6");
        b.move("b1","c3");
        b.move("f8","c5");
        b.display();
    }
    
}
