import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class Board {
    private ArrayList<ArrayList<Square>> board;
    private ArrayList<Piece> graveyard;
    public Board(){ // initialize the board with the pieces not in the GameLogic. Tony 15.10
        // TODO: init board with all pieces.
        this.board= init_board();
        this.graveyard= new ArrayList<Piece>();
    }

    private ArrayList<ArrayList<Square>> init_board() {
        ArrayList<ArrayList<Square>> list_copy = new ArrayList<>();
        for (int i = 0;i<=7;i++){
            list_copy.add(new ArrayList<>());
        }
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.T,false), "A8"));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.N,false), "B8"));
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.B,false), "C8"));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.Q,false), "D8"));
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.K,false), "E8"));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.B,false), "F8"));
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.N,false), "G8"));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.T,false), "H8"));
        List<String> liste_abc = Arrays.asList("A", "C", "E", "G");
        List<String> liste_abc2= Arrays.asList("B", "D", "F", "H");

        for (int i=0;i<=3;i++){
            list_copy.get(1).add(new Square(ColorSquare.B, new Piece(Color.B, Type.P,false), liste_abc.get(i)+"7"));
            list_copy.get(1).add(new Square(ColorSquare.W, new Piece(Color.B, Type.P,false), liste_abc2.get(i)+"7"));

        }
        for (int i=0;i<=3;i++){
            list_copy.get(2).add(new Square(ColorSquare.W, null, liste_abc.get(i)+"6"));
            list_copy.get(2).add(new Square(ColorSquare.B, null, liste_abc2.get(i)+"6"));

        }
        for (int i=0;i<=3;i++){
            list_copy.get(3).add(new Square(ColorSquare.B, null, liste_abc.get(i)+"5"));
            list_copy.get(3).add(new Square(ColorSquare.W, null, liste_abc2.get(i)+"5"));

        }
        for (int i=0;i<=3;i++){
            list_copy.get(4).add(new Square(ColorSquare.W, null, liste_abc.get(i)+"4"));
            list_copy.get(4).add(new Square(ColorSquare.B, null, liste_abc2.get(i)+"4"));

        }
        for (int i=0;i<=3;i++){
            list_copy.get(5).add(new Square(ColorSquare.B, null, liste_abc.get(i)+"3"));
            list_copy.get(5).add(new Square(ColorSquare.W, null, liste_abc2.get(i)+"3"));

        }

        for (int i = 0; i<=3; i++) {
            list_copy.get(6).add(new Square(ColorSquare.W, new Piece(Color.W, Type.P,false), liste_abc.get(i)+"2"));
            list_copy.get(6).add(new Square(ColorSquare.B, new Piece(Color.W, Type.P,false), liste_abc.get(i)+"2"));
        }
        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.T,false), "A1"));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.N,false), "B1"));
        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.B,false), "C1"));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.Q,false), "D1"));
        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.K,false), "E1"));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.B,false), "F1"));
        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.N,false), "G1"));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.T,false), "H1"));
        return list_copy;
    }

    public void print(){
        int i = 8;
        for (ArrayList<Square> list : this.board){
            System.out.print("[" + i + "]");
            for (Square square : list){
                System.out.print(square);
            }
            i--;
            System.out.println();
        }
        System.out.println("[ ][ A ][ B ][ C ][ D ][ E ][ F ][ G ][ H ]");
        System.out.println("Eaten Figures: " + this.graveyard);
    }

    public Piece move(String position, String target){ //TODO Set new piece status moved = true
        Piece move_piece = get_Piece_from_position(position);
        if (move_piece.getColor() == Color.B){

        }
        Piece target_piece = get_Piece_from_position(target);
        if (target_piece != null){
            this.graveyard.add(target_piece);
        }
        this.board.get("87654321".indexOf(target.substring(1))).set("ABCDEFGH".indexOf(target.substring(0,1)), new Square(get_Square_from_position(target).get_Color(), move_piece, target));
        this.board.get("87654321".indexOf(position.substring(1))).set("ABCDEFGH".indexOf(position.substring(0,1)), new Square(get_Square_from_position(position).get_Color(), null, position));
        move_piece.change_has_moved(); // when moved then change his has_moved state
        return target_piece;
    }

    public boolean valid_turn(Player player, Piece piece){
        // returns ob de player dra isch oder nid.

        if (piece == null) { return true; }
        return player.get_color() != piece.getColor();
    }

    public boolean valid_input(String algebraic_not){
        /** @param algebraic_not like in in the assignments requirements
         * @return boolean if it is like the requirements
         */
        String regex = "[A-H][1-8]"; //input should be a uppercase letter from A-H and a digit from 1-8
        Pattern pattern = Pattern.compile(regex);
        return algebraic_not.matches(regex);
    }

    public Piece get_Piece_from_position(String position){
        //split the coordinates
        if (!valid_input(position)){
            return null;
        }

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

    public ArrayList<ArrayList<Square>> getBoard(){
        ArrayList<ArrayList<Square>> list_copy = new ArrayList<>();
        list_copy.addAll(this.board);
        return list_copy;
    }

    public void fake_flush() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}