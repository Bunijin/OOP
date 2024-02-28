package lab8;

public class Main {

    public static void main(String[] args) {
        ChessBoard b = new ChessBoard();
        b.create("Bishop",true,"e4");
        b.create("rook",true,"e5");
        b.create("queen",false, "c5");
        b.display();
        b.move("e4", "e4");
        b.display();
    }
    
}
