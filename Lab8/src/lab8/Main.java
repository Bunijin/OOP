package lab8;

public class Main {

    public static void main(String[] args) {
        ChessBoard b = new ChessBoard();
        b.create("Bishop",'w',"e4");
        b.create("rook",'w',"e5");
        b.create("queen",'b', "c5");
        b.move("c5", "d5");
        b.move("d5","e4");
    }
    
}