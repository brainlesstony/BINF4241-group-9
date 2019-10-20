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

    public Piece move_check(String position, String target){
        // TODO: move method, all checks done here (is move possible, checkmate etc.)
        Type type = get_Piece_from_position(position).getType();
        ArrayList<String> possible_moves = new ArrayList<>();
        String abc = "ABCDEFGH";
        String numbers = "87654321";
        switch (type){
            case K://King
                break;
            case Q://Queen
                break;
            case P://Pawn
                if (position.substring(1).equals("2")){
                    possible_moves.add(position.substring(0,1) + numbers.substring(numbers.indexOf(position.substring(1))+2));
                }
                else if (position.substring(1).equals("7")) {
                    possible_moves.add(position.substring(0,1) + numbers.substring(numbers.indexOf(position.substring(1))-2));
                }
                else {
                    // falls der pawn einen fressen kann
                    ArrayList<String> possible_destinations = new ArrayList<>();
                    possible_destinations.add(abc.substring(abc.indexOf(position.substring(0,1))+1)+numbers.substring(numbers.indexOf(position.substring(1))+1));
                    possible_destinations.add(abc.substring(abc.indexOf(position.substring(0,1))+1)+numbers.substring(numbers.indexOf(position.substring(1))-1));
                    possible_destinations.add(abc.substring(abc.indexOf(position.substring(0,1))-1)+numbers.substring(numbers.indexOf(position.substring(1))+1));
                    possible_destinations.add(abc.substring(abc.indexOf(position.substring(0,1))-1)+numbers.substring(numbers.indexOf(position.substring(1))-1));

                    if(get_Piece_from_position(position).getColor()==Color.B){
                        possible_moves.add(position.substring(0,1)+numbers.substring(numbers.indexOf(position.substring(1))-1));
                    }
                    else if (get_Piece_from_position(position).getColor()==Color.W){
                        possible_moves.add(position.substring(0,1)+numbers.substring(numbers.indexOf(position.substring(1))+1));
                    }
                    for (String ziel: possible_destinations) {
                        if(get_Piece_from_position(ziel)!=null){
                            if(get_Piece_from_position(ziel).getColor()!=get_Piece_from_position(position).getColor()){
                                possible_moves.add(ziel);
                            }
                        }
                    }

                    if (possible_moves.contains(target)){
                        return move(position, target);
                    }
                }
                break;
            case T://Tower
                break;
            case N://Knight
                break;
        }
        return null;
    }

    public Piece move(String position, String target){
        Piece move_piece = get_Piece_from_position(position);
        Piece target_piece = get_Piece_from_position(target);
        this.board.get(Integer.parseInt(target.substring(1))-1).set("ABCDEFGH".indexOf(target.substring(0,1)), new Square(get_Square_from_position(target).get_Color(), move_piece));
        this.board.get(Integer.parseInt(target.substring(1))-1).set("ABCDEFGH".indexOf(position.substring(0,1)), new Square(get_Square_from_position(position).get_Color(), null));
        return target_piece;
    }

    public Piece get_Piece_from_position(String position){
        //split the coordinates
        String row = position.substring(1);
        String column = position.substring(0,1);
        String abc = "ABCDEFGH";
        String numbers = "87654321";

        if (this.board.get(numbers.indexOf(row)).get(abc.indexOf(column)).get_Piece() != null){
            return this.board.get(numbers.indexOf(row)).get(abc.indexOf(column)).get_Piece();
        }
        else{
            return null;
        }
    }

    public Square get_Square_from_position(String position){
        String row = position.substring(1);
        String column = position.substring(0,1);
        String abc = "ABCDEFGH";
        String numbers = "87654321";

        return this.board.get(numbers.indexOf(row)).get(abc.indexOf(column));

    }

    public boolean checkmate(){
        return false; // TODO: need to check first if king in danger
    }

    public void flush() {
        System.out.flush();
    } // deletes the previous board on the screen but this does not happen in the Intellij console but in the terminal
}