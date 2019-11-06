import java.util.ArrayList;

public class BoardIteratorY implements Iterator {
    ArrayList<ArrayList<Square>> board;
    int position = 0;

    public BoardIteratorY(ArrayList<ArrayList<Square>> board) {
        this.board = board;
    }

    public ArrayList<Square> next() {
        ArrayList<Square> liste = board.get(position);
        position++;
        return liste;
    }

    public boolean hasNext() {
        if (position >= board.size() | board.get(position) == null) {
            return false;
        } else {
            return true;
        }
    }
}

