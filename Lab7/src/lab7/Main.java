package lab7;

public class Main {

    public static void main(String[] args) {
        ChessBoard b = new ChessBoard();
        b.create("Knight", 'w', 'a', 8);    //Kna8
        b.create("Rook", 'w', 'g', 1);      //Rg1
        b.create("Bishop", 'b', 'c', 8);    //Bc8
        b.freeMove("Bishop",'a',7);         //Ba7
        b.freeMove("Knight",'g',1);         //Rook is on g1
        b.freeMove("Knight",'a',7);         //Knxba7
        b.freeMove("Knight",'e',6);         //Kne6
        b.create("King",'w','c',5);         //Kc5
    }
    
}