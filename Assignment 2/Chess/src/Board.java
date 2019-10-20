import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.T), "A8"));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.N), "B8"));
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.B), "C8"));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.Q), "D8"));
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.K), "E8"));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.B), "F8"));
        list_copy.get(0).add(new Square(ColorSquare.W, new Piece(Color.B, Type.N), "G8"));
        list_copy.get(0).add(new Square(ColorSquare.B, new Piece(Color.B, Type.T), "H8"));
        List<String> liste_abc = Arrays.asList("A", "C", "E", "G");
        List<String> liste_abc2= Arrays.asList("B", "D", "F", "H");

        for (int i=0;i<=3;i++){
            list_copy.get(1).add(new Square(ColorSquare.B, new Piece(Color.B, Type.P), liste_abc.get(i)+"7"));
            list_copy.get(1).add(new Square(ColorSquare.W, new Piece(Color.B, Type.P), liste_abc2.get(i)+"7"));

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
            list_copy.get(6).add(new Square(ColorSquare.W, new Piece(Color.W, Type.P), liste_abc.get(i)+"2"));
            list_copy.get(6).add(new Square(ColorSquare.B, new Piece(Color.W, Type.P), liste_abc.get(i)+"2"));
        }
        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.T), "A1"));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.N), "B1"));
        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.B), "C1"));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.Q), "D1"));
        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.K), "E1"));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.B), "F1"));
        list_copy.get(7).add(new Square(ColorSquare.B, new Piece(Color.W, Type.N), "G1"));
        list_copy.get(7).add(new Square(ColorSquare.W, new Piece(Color.W, Type.T), "H1"));
        return list_copy;
    }


    public void print(){
        for (ArrayList list : this.board){
            System.out.println(list);
        }
        // TODO: should also print the eaten Figures
    }

    public boolean move_check(String position, String target){
        // TODO: move method, all checks done here (is move possible, checkmate etc.)
        Type type = get_Piece_from_position(position).getType();
        ArrayList<String> possible_moves = new ArrayList<>();
        String abc = "ABCDEFGH";
        String numbers = "87654321";
        switch (type){
            case K://King
                try {
                    possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))+1)+numbers.substring(numbers.indexOf(position.substring(1))+1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))+1)+numbers.substring(numbers.indexOf(position.substring(1))));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))+1)+numbers.substring(numbers.indexOf(position.substring(1))-1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1)))+numbers.substring(numbers.indexOf(position.substring(1))+1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1)))+numbers.substring(numbers.indexOf(position.substring(1))-1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))-1)+numbers.substring(numbers.indexOf(position.substring(1))+1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))-1)+numbers.substring(numbers.indexOf(position.substring(1))));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))-1)+numbers.substring(numbers.indexOf(position.substring(1))-1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                break;
            case Q://Queen
                int i = 1;
                while(true){//nach rechts
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1))+i)+position.substring(1)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))+i)+numbers.substring(numbers.indexOf(position.substring(1))));
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
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1))-i)+position.substring(1)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))-i)+numbers.substring(numbers.indexOf(position.substring(1))));
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
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1)))+numbers.substring(numbers.indexOf(position.substring(1))+i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1)))+numbers.substring(numbers.indexOf(position.substring(1))+i));
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
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1)))+numbers.substring(numbers.indexOf(position.substring(1))-i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1)))+numbers.substring(numbers.indexOf(position.substring(1))-i));
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
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1))-i)+numbers.substring(numbers.indexOf(position.substring(1))-i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))-i)+numbers.substring(numbers.indexOf(position.substring(1))-i));
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
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1))+i)+numbers.substring(numbers.indexOf(position.substring(1))-i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))+i)+numbers.substring(numbers.indexOf(position.substring(1))-i));
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
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1))-i)+numbers.substring(numbers.indexOf(position.substring(1))+i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))-i)+numbers.substring(numbers.indexOf(position.substring(1))+i));
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
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1))+i)+numbers.substring(numbers.indexOf(position.substring(1))+i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))+i)+numbers.substring(numbers.indexOf(position.substring(1))+i));
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
                if (position.substring(1).equals("2")){
                    possible_moves.add(position.substring(0,1) + numbers.substring(numbers.indexOf(position.substring(1))+2));
                }
                else if (position.substring(1).equals("7")) {
                    possible_moves.add(position.substring(0,1) + numbers.substring(numbers.indexOf(position.substring(1))-2));
                }
                else {
                    // falls der pawn einen fressen kann
                    ArrayList<String> possible_destinations = new ArrayList<>();
                    try {
                        possible_destinations.add(abc.substring(abc.indexOf(position.substring(0,1))+1)+numbers.substring(numbers.indexOf(position.substring(1))+1));
                    }
                    catch (Exception ArrayIndexOutOfBounds){
                    }
                    try {
                        possible_destinations.add(abc.substring(abc.indexOf(position.substring(0,1))+1)+numbers.substring(numbers.indexOf(position.substring(1))-1));
                    }
                    catch(Exception ArrayIndexOutOfBounds){
                    }
                    try{
                        possible_destinations.add(abc.substring(abc.indexOf(position.substring(0,1))-1)+numbers.substring(numbers.indexOf(position.substring(1))+1));
                    }
                    catch(Exception ArrayIndexOutOfBounds){
                    }
                    try{
                        possible_destinations.add(abc.substring(abc.indexOf(position.substring(0,1))-1)+numbers.substring(numbers.indexOf(position.substring(1))-1));
                    }
                    catch(Exception ArrayIndexOutOfBounds){
                    }

                    if(get_Piece_from_position(position).getColor()==Color.B){
                        try{
                            possible_moves.add(position.substring(0,1)+numbers.substring(numbers.indexOf(position.substring(1))-1));
                        }
                        catch (Exception ArrayIndexOutOfBounds){
                        }
                    }
                    else if (get_Piece_from_position(position).getColor()==Color.W){
                        try{
                            possible_moves.add(position.substring(0,1)+numbers.substring(numbers.indexOf(position.substring(1))+1));
                        }
                        catch (Exception ArrayIndexOutOfBounds){
                        }
                    }
                    for (String ziel: possible_destinations) {
                        if(get_Piece_from_position(ziel)!=null){
                            if(get_Piece_from_position(ziel).getColor()!=get_Piece_from_position(position).getColor()){
                                possible_moves.add(ziel);
                            }
                        }
                    }
                }
                break;
            case T://Tower
                i = 1;
                while(true){//nach rechts
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1))+i)+position.substring(1)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))+i)+numbers.substring(numbers.indexOf(position.substring(1))));
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
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1))-i)+position.substring(1)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))-i)+numbers.substring(numbers.indexOf(position.substring(1))));
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
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1)))+numbers.substring(numbers.indexOf(position.substring(1))+i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1)))+numbers.substring(numbers.indexOf(position.substring(1))+i));
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
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1)))+numbers.substring(numbers.indexOf(position.substring(1))-i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1)))+numbers.substring(numbers.indexOf(position.substring(1))-i));
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
                    possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))+1)+numbers.substring(numbers.indexOf(position.substring(1))+2));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))-1)+numbers.substring(numbers.indexOf(position.substring(1))+2));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))-2)+numbers.substring(numbers.indexOf(position.substring(1))+1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))-2)+numbers.substring(numbers.indexOf(position.substring(1))-1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))-1)+numbers.substring(numbers.indexOf(position.substring(1))-2));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))+1)+numbers.substring(numbers.indexOf(position.substring(1))-2));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))+2)+numbers.substring(numbers.indexOf(position.substring(1))+1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                try {
                    possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))+2)+numbers.substring(numbers.indexOf(position.substring(1))-1));
                }
                catch (Exception ArrayIndexOutOfBounds){
                }
                break;
            case B: //Bishop
                i = 1;
                while(true){//diagonal
                    try{
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1))-i)+numbers.substring(numbers.indexOf(position.substring(1))-i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))-i)+numbers.substring(numbers.indexOf(position.substring(1))-i));
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
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1))+i)+numbers.substring(numbers.indexOf(position.substring(1))-i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))+i)+numbers.substring(numbers.indexOf(position.substring(1))-i));
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
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1))-i)+numbers.substring(numbers.indexOf(position.substring(1))+i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))-i)+numbers.substring(numbers.indexOf(position.substring(1))+i));
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
                        if (get_Square_from_position(abc.substring(abc.indexOf(position.substring(0,1))+i)+numbers.substring(numbers.indexOf(position.substring(1))+i)).get_Piece()==null){
                            possible_moves.add(abc.substring(abc.indexOf(position.substring(0,1))+i)+numbers.substring(numbers.indexOf(position.substring(1))+i));
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

    public Piece move(String position, String target){
        Piece move_piece = get_Piece_from_position(position);
        Piece target_piece = get_Piece_from_position(target);

        this.board.get("87654321".indexOf(target.substring(1))).set("ABCDEFGH".indexOf(target.substring(0,1)), new Square(get_Square_from_position(target).get_Color(), move_piece, target));
        this.board.get("87654321".indexOf(position.substring(1))).set("ABCDEFGH".indexOf(position.substring(0,1)), new Square(get_Square_from_position(position).get_Color(), null, position));
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