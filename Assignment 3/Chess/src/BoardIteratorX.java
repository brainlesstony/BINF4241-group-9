import java.util.ArrayList;

public class BoardIteratorX implements Iterator {
    ArrayList<Square> board;
    int position = 0;

    public BoardIteratorX(ArrayList<Square> board) {
        this.board = board;
    }

    public Square next() {
        Square square = board.get(position);
        position++;
        return square;
    }

    public boolean hasNext() {
        if (position >= board.size() | board.get(position) == null) {
            return false;
        } else {
            return true;
        }
}