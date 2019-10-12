import java.util.ArrayList;

public class Board {
    public List<Square>[] board = new ArrayList(63);

    private void init_board() {
        for (int i = 0; i < 63;i++) {
            for (Column col:Column.values()){
                //A
                for (Row row:Row.values()) {
                    //ONE,TWO
                    if (i%2 == 0) {
                        //Color.White
                    }
                    else{
                        //Color.Black
                    }
            }


//            if (i % 2== 0) {
//                board[i] = new Square(Color.White, Row.One,Column.A);
            }
        }

    }
}