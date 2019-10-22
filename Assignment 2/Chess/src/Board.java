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
        for (ArrayList list : this.board){
            System.out.println(list);
        }
        System.out.println("Eaten Figures: " + this.graveyard);
    }

    public boolean move_check(String position, String target){
        // TODO: move method, all checks done here (is move possible, checkmate etc.)
        Type type = get_Piece_from_position(position).getType();
        ArrayList<String> possible_moves = new ArrayList<>();
        String abc = "ABCDEFGH";
        String numbers = "87654321";
        String row_position = position.substring(1);
        String column_position = position.substring(0, 1);
        switch (type){
            case K://King
                try {
                    possible_moves.add(abc.substring(abc.indexOf(column_position)+1, abc.indexOf(column_position)+2) + numbers.substring(numbers.indexOf(row_position)+1, numbers.indexOf(row_position)+1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(column_position)+1,abc.indexOf(column_position)+2)+numbers.substring(numbers.indexOf(row_position), numbers.indexOf(row_position)+1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                possible_moves.add(abc.substring(abc.indexOf(column_position)+1, abc.indexOf(column_position)+2)+numbers.substring(numbers.indexOf(row_position)-1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(column_position))+numbers.substring(numbers.indexOf(row_position)+1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(column_position))+numbers.substring(numbers.indexOf(row_position)-1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(column_position)-1)+numbers.substring(numbers.indexOf(row_position)+1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(column_position)-1)+numbers.substring(numbers.indexOf(row_position)));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(column_position)-1)+numbers.substring(numbers.indexOf(row_position)-1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                break;
            case Q://Queen
                int i = 1;
                while(true){//nach rechts
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position)+i)+row_position).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position)+i)+numbers.substring(numbers.indexOf(row_position)));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
                i=1;
                while(true){//nach links
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position)-i)+row_position).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position)-i)+numbers.substring(numbers.indexOf(row_position)));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
                i=1;
                while(true){//nach unten
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position))+numbers.substring(numbers.indexOf(row_position)+i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position))+numbers.substring(numbers.indexOf(row_position)+i));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
                i=1;
                while(true){//nach oben
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position))+numbers.substring(numbers.indexOf(row_position)-i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position))+numbers.substring(numbers.indexOf(row_position)-i));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
                i=1;
                while(true){//diagonal
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position)-i)+numbers.substring(numbers.indexOf(row_position)-i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position)-i)+numbers.substring(numbers.indexOf(row_position)-i));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
                i=1;
                while(true){//diagonal
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position)+i)+numbers.substring(numbers.indexOf(row_position)-i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position)+i)+numbers.substring(numbers.indexOf(row_position)-i));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
                i=1;
                while(true){//diagonal
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position)-i)+numbers.substring(numbers.indexOf(row_position)+i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position)-i)+numbers.substring(numbers.indexOf(row_position)+i));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
                i=1;
                while(true){//diagonal
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position)+i)+numbers.substring(numbers.indexOf(row_position)+i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position)+i)+numbers.substring(numbers.indexOf(row_position)+i));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
                break;
            case P://Pawn
                if (row_position.equals("2")){
                    possible_moves.add(column_position + numbers.substring(numbers.indexOf(row_position)-2,numbers.indexOf(row_position)-1));

                }
                else if (row_position.equals("7")) {
                    possible_moves.add(column_position + numbers.substring(numbers.indexOf(row_position)+2, numbers.indexOf(row_position)+1));
                }
                else {
                    // falls der pawn einen fressen kann
                    ArrayList<String> possible_destinations = new ArrayList<>();
                    try {
                        possible_destinations.add(abc.substring(abc.indexOf(column_position)+1)+numbers.substring(numbers.indexOf(row_position)+1));
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                    }
                    try {
                        possible_destinations.add(abc.substring(abc.indexOf(column_position)+1)+numbers.substring(numbers.indexOf(row_position)-1));
                    }
                    catch(Exception ArrayIndexOutOfBounds){
                    }
                    try{
                        possible_destinations.add(abc.substring(abc.indexOf(column_position)-1)+numbers.substring(numbers.indexOf(row_position)+1));
                    }
                    catch(Exception ArrayIndexOutOfBounds){
                    }
                    try{
                        possible_destinations.add(abc.substring(abc.indexOf(column_position)-1)+numbers.substring(numbers.indexOf(row_position)-1));
                    }
                    catch(Exception ArrayIndexOutOfBounds){
                    }

                    for (String ziel: possible_destinations) {
                        if(get_Piece_from_position(ziel)!=null){
                            if(get_Piece_from_position(ziel).getColor()!=get_Piece_from_position(position).getColor()){
                                possible_moves.add(ziel);
                            }
                        }
                    }
                }
                if(get_Piece_from_position(position).getColor()==Color.B){
                    try{
                        possible_moves.add(column_position+numbers.substring(numbers.indexOf(row_position)+1));
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                    }
                }
                else if (get_Piece_from_position(position).getColor()==Color.W){
                    try{
                        possible_moves.add(column_position+numbers.substring(numbers.indexOf(row_position)-1));
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                    }
                }
                break;
            case T://Tower
                i = 1;
                while(true){//nach rechts
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position)+i)+row_position).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position)+i)+numbers.substring(numbers.indexOf(row_position)));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
                i=1;
                while(true){//nach links
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position)-i)+row_position).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position)-i)+numbers.substring(numbers.indexOf(row_position)));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
                i=1;
                while(true){//nach unten
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position))+numbers.substring(numbers.indexOf(row_position)+i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position))+numbers.substring(numbers.indexOf(row_position)+i));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
                i=1;
                while(true){//nach oben
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position))+numbers.substring(numbers.indexOf(row_position)-i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position))+numbers.substring(numbers.indexOf(row_position)-i));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
                break;
            case N://Knight
                try {
                    possible_moves.add(abc.substring(abc.indexOf(column_position)+1)+numbers.substring(numbers.indexOf(row_position)+2));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(column_position)-1)+numbers.substring(numbers.indexOf(row_position)+2));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(column_position)-2)+numbers.substring(numbers.indexOf(row_position)+1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(column_position)-2)+numbers.substring(numbers.indexOf(row_position)-1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(column_position)-1)+numbers.substring(numbers.indexOf(row_position)-2));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(column_position)+1)+numbers.substring(numbers.indexOf(row_position)-2));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(column_position)+2)+numbers.substring(numbers.indexOf(row_position)+1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(column_position)+2)+numbers.substring(numbers.indexOf(row_position)-1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                break;
            case B: //Bishop
                i = 1;
                while(true){//diagonal
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position)-i)+numbers.substring(numbers.indexOf(row_position)-i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position)-i)+numbers.substring(numbers.indexOf(row_position)-i));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
                i=1;
                while(true){//diagonal
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position)+i)+numbers.substring(numbers.indexOf(row_position)-i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position)+i)+numbers.substring(numbers.indexOf(row_position)-i));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
                i=1;
                while(true){//diagonal
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position)-i)+numbers.substring(numbers.indexOf(row_position)+i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position)-i)+numbers.substring(numbers.indexOf(row_position)+i));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
                i=1;
                while(true){//diagonal
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(column_position)+i)+numbers.substring(numbers.indexOf(row_position)+i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(column_position)+i)+numbers.substring(numbers.indexOf(row_position)+i));
                            i++;
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                        break;
                    }
                }
        }
        if (possible_moves.contains(target)){
            return true;
        }
        else {
            return false;
        }
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

    public boolean check_empty(String field){
        String row = field.substring(1);
        String column = field.substring(0,1);
        String abc = "ABCDEFGH";
        String numbers = "87654321";
        Piece dummy = this.board.get(numbers.indexOf(row)).get(abc.indexOf(column)).get_Piece();
        return dummy == null;
    }

    public Color get_color_of_piece(String position){
        String row = position.substring(1);
        String column = position.substring(0,1);
        String abc = "ABCDEFGH";
        String numbers = "87654321";

        return this.board.get(numbers.indexOf(row)).get(abc.indexOf(column)).get_Piece().getColor();
    }

    public boolean checkmate(){
        return false; // TODO: need to check first if king in danger
    }

    public void flush() {
        System.out.flush();
    } // deletes the previous board on the screen but this does not happen in the Intellij console but in the terminal
}