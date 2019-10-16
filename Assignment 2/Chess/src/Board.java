import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Square>> board;
    public Board(){ // initialize the board with the pieces not in the GameLogic. Tony 15.10
        // TODO: init board with all pieces.
        this.board= init_board();
    }

    private ArrayList<ArrayList<Square>> init_board() {
        ArrayList<ArrayList<Square>> list_copy = new ArrayList<>();
        for (int i = 0;i<=7;i++){
            list_copy.add(new ArrayList<>());
        }
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.T)));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.N)));
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.B)));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.Q)));
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.K)));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.B)));
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.N)));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.T)));
        for (int i = 0; i<=3; i++){
            list_copy.get(1).add(new Square(ColorSquare.B, new Piece(Color.B, Type.P)));
            list_copy.get(1).add(new Square(ColorSquare.W, new Piece(Color.B, Type.P)));
        }
        for (int i = 2; i<=5; i++){
            for (int j = 0; j<=3; j++){
                if (i % 2==0){
                    list_copy.get(i).add(new Square(ColorSquare.W, null));
                    list_copy.get(i).add(new Square(ColorSquare.B, null));
                }
                else{
                    list_copy.get(i).add(new Square(ColorSquare.B, null));
                    list_copy.get(i).add(new Square(ColorSquare.W, null));
                }
            }
        }
        for (int i = 0; i<=3; i++) {
            list_copy.get(6).add(new Square(ColorSquare.W, new Piece(Color.W, Type.P)));
            list_copy.get(6).add(new Square(ColorSquare.B, new Piece(Color.W, Type.P)));
        }
        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.T)));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.N)));
        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.B)));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.K)));
        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.Q)));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.B)));
        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.N)));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.T)));
        return list_copy;
    }


    public void print(){
        for (ArrayList list : board){
            System.out.println(list);
        }
        // TODO: should also print the eaten Figures
    }

    public void move(String piece, String target){
        // TODO: move method, all checks done here (is move possible, checkmate etc.)
        Type type = get_Piece_from_position(piece).getType();
        switch (type){
            case K://King
                break;
            case Q://Queen
                break;
            case P://Pawn
                break;
            case T://Tower
                break;
            case N://Knight
                break;
        }
    }

    public Piece get_Piece_from_position(String position){
        //split the coordinates
        String row = position.substring(1);
        String column = position.substring(0,1);
        String abc = "ABCDEFGH";
        String numbers = "87654321";

        System.out.println(row);
        System.out.println(column);

        if (this.board.get(numbers.indexOf(row)).get(abc.indexOf(column)).get_Piece() != null){
            return this.board.get(numbers.indexOf(row)).get(abc.indexOf(column)).get_Piece();
        }
        else{
            return null;
        }
        // then implement logic for retrieval of piece at this location or null if there is no piece
        // TODO: returns the piece for this position, can be done because attributes of a piece are immutable
    }

    public boolean checkmate(){
        return false; // TODO: need to check first if king in danger
    }

    public void flush() {
        System.out.flush();
    } // deletes the previous board on the screen but this does not happen in the Intellij console but in the terminal
}