import java.util.ArrayList;

public class BoardIterator implements Iterator {
    private ArrayList<Square> board;
    private int position = 0;

    public BoardIterator(ArrayList<Square> board) {
        this.board = board;
    }

    public Square next() {
        Square square = board.get(position);
        position++;
        return square;
    }

    public boolean hasNext() {
        if (position >= board.size() || board.get(position) == null) {
            return false;
        } else {
            return true;
        }
    }
    public void reset(){
        position = 0;
    }
}