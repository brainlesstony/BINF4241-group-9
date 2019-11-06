import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class Singleton implements Score {

    private ArrayList<ArrayList<Square>> board;
    private ArrayList<Piece> graveyard;

    private static Singleton uniqueInstance; // Board
    private Singleton(){
        this.board= init_board();
        this.graveyard= new ArrayList<Piece>();
    }

    public static Singleton getInstance() {
        if(uniqueInstance == null){
            uniqueInstance = new Singleton();
        }
        return  uniqueInstance;
    }
//    public Iterator createIteratorX(){
//        return new BoardIteratorX(board);
//    }
//    public Iterator createIteratorY(){
//        return new BoardIteratorY(board);
//    }

//    public Board(){ // initialize the board with the pieces not in the GameLogic. Tony 15.10
//        // TODO: init board with all pieces.
//        this.board= init_board();
//        this.graveyard= new ArrayList<Piece>();
//    }


//    Iterator iterator = Board.createIterator();

    public ArrayList<Square> iterator_list(){
        ArrayList<Square> tmp;
        tmp = new ArrayList<>();
        for(ArrayList<Square> liste: this.board){
            tmp.addAll(liste);

        }
        return tmp;
    }

    private ArrayList<ArrayList<Square>> init_board() {
        ArrayList<ArrayList<Square>> list_copy = new ArrayList<>();
        for (int i = 0;i<=7;i++){
            list_copy.add(new ArrayList<>());
        }
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.T,false), "A8",true));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.N,false), "B8",true));
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.B,false), "C8",true));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.Q,false), "D8",true));
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.K,false), "E8",true));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.B,false), "F8",true));
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.N,false), "G8",true));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.T,false), "H8",true));
        List<String> liste_abc = Arrays.asList("A", "C", "E", "G");
        List<String> liste_abc2= Arrays.asList("B", "D", "F", "H");

        for (int i=0;i<=3;i++){
            list_copy.get(1).add(new Square(ColorSquare.B, new Piece(Color.B, Type.P,false), liste_abc.get(i)+"7",false));
            list_copy.get(1).add(new Square(ColorSquare.W, new Piece(Color.B, Type.P,false), liste_abc2.get(i)+"7",false));

        }
        for (int i=0;i<=3;i++){
            list_copy.get(2).add(new Square(ColorSquare.W, null, liste_abc.get(i)+"6",false));
            list_copy.get(2).add(new Square(ColorSquare.B, null, liste_abc2.get(i)+"6",false));

        }
        for (int i=0;i<=3;i++){
            list_copy.get(3).add(new Square(ColorSquare.B, null, liste_abc.get(i)+"5",false));
            list_copy.get(3).add(new Square(ColorSquare.W, null, liste_abc2.get(i)+"5",false));

        }
        for (int i=0;i<=3;i++){
            list_copy.get(4).add(new Square(ColorSquare.W, null, liste_abc.get(i)+"4",false));
            list_copy.get(4).add(new Square(ColorSquare.B, null, liste_abc2.get(i)+"4",false));

        }
        for (int i=0;i<=3;i++){
            list_copy.get(5).add(new Square(ColorSquare.B, null, liste_abc.get(i)+"3",false));
            list_copy.get(5).add(new Square(ColorSquare.W, null, liste_abc2.get(i)+"3",false));

        }

        for (int i = 0; i<=3; i++) {
            list_copy.get(6).add(new Square(ColorSquare.W, new Piece(Color.W, Type.P,false), liste_abc.get(i)+"2",false));
            list_copy.get(6).add(new Square(ColorSquare.B, new Piece(Color.W, Type.P,false), liste_abc2.get(i)+"2",false));
        }

        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.T,false), "A1",true));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.N,false), "B1",true));
        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.B,false), "C1",true));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.Q,false), "D1",true));
        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.K,false), "E1",true));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.B,false), "F1",true));
        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.N,false), "G1",true));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.T,false), "H1",true));
        return list_copy;
    }


    public void print(){
        int i = 8;
        String ANSI_Reset = "\u001B[0m";
        String ANSI_Green = "\u001B[32m"; //yellow 33, blue 34, cyan 36
        for (ArrayList<Square> list : this.board){
            System.out.print(ANSI_Green+"[" + i + "]"+ANSI_Reset);
            for (Square square : list){
                System.out.print(square);
            }
            i--;
            System.out.println();
        }

        System.out.println(ANSI_Green+"[ ][ A ][ B ][ C ][ D ][ E ][ F ][ G ][ H ]"+ANSI_Reset);
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
        this.board.get("87654321".indexOf(target.substring(1))).set("ABCDEFGH".indexOf(target.substring(0,1)), new Square(get_Square_from_position(target).get_Color(), move_piece, target,true));
        this.board.get("87654321".indexOf(position.substring(1))).set("ABCDEFGH".indexOf(position.substring(0,1)), new Square(get_Square_from_position(position).get_Color(), null, position,false));
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

    public void fake_flush(){
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public int getWhitePieces(){
        int result = 0;
        for (Piece piece : graveyard){
            if (piece.getColor() == Color.W){
                if (piece.getType() == Type.Q){
                    result = result+5;
                }
                else{
                    result++;
                }
            }
        }
        return result;
    }

    public int getBlackPieces(){
        int result = 0;
        for (Piece piece : graveyard){
            if (piece.getColor() == Color.B){
                if (piece.getType() == Type.Q){
                    result = result+5;
                }
                else{
                    result++;
                }
            }
        }
        return result;
    }

    private List<Observer> observers = new ArrayList<Observer>();

    public void registerObserver(Observer aObserver){
        observers.add(aObserver);
    }

    public void removeObserver(Observer aObserver){
        if (observers.contains(aObserver)) {
            observers.remove(aObserver);
        }
    }

    public void notifyObservers(int white_score, int black_score){
        for(Observer eachObserver : observers){
            eachObserver.update(white_score, black_score);
        }
    }

    public void scoreChanged(){
        int white_score = getBlackPieces();
        int black_score = getWhitePieces();

        notifyObservers(white_score, black_score);
    }

    public Iterator createIterator(){
        return new BoardIterator(this.iterator_list());
    }
}