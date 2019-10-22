import javax.xml.crypto.dsig.TransformService;
import java.util.ArrayList;

public class Move {
    public boolean move_check(String start, //TODO BLOCKED doesn't work yet
                              String end, ArrayList<ArrayList<Square>> board){
        String columns = "ABCDEFGH";
        String rows = "87654321";
        Piece piece = get_Piece_from_position(start, board);

        Type type = piece.getType();
        Color color = piece.getColor();


        if (!columns.contains(start.substring(0,1))||   //falls eine der eingegebenen Positionen nicht stimmen
            !columns.contains(end.substring(0,1))||
            !rows.contains(start.substring(1))||
            !rows.contains(end.substring(1))){
            return false;
        }
        if (!check_empty(end, board)){ // falls auf zielfeld eine Figur mit gleicher Farbe steht
            if(get_color_of_piece(end, board)==get_color_of_piece(start, board)){
                return false;
            }
        }

        int start_row = rows.indexOf(start.substring(1))+1;
        int start_column = columns.indexOf(start.substring(0,1))+1;

        int end_row = rows.indexOf(end.substring(1))+1;
        int end_column = columns.indexOf(end.substring(0,1))+1;

        int delta_rows = end_row - start_row;
        int delta_column = end_column - start_column;

        switch (type){
            case B:
                if (delta_column >=-1 && delta_column <= 1 && delta_rows <=1 && delta_rows >= -1){
                    return true;
                }
                if (delta_column < 0 && delta_rows > 0){
                    for (int i = 1; i < Math.abs(delta_column); i++){
                        if (!check_empty(translation_list_index(start_row + i, start_column - i), board)){
                            return false;
                        }
                    }
                }
                else if (delta_column > 0 && delta_rows > 0){
                    for (int i = 1; i < Math.abs(delta_column); i++){
                        if (!check_empty(translation_list_index(start_row + i, start_column + i), board)){
                            return false;
                        }
                    }
                }
                else if (delta_column < 0 && delta_rows < 0){
                    for (int i = 1; i < Math.abs(delta_column); i++){
                        if (!check_empty(translation_list_index(start_row - i, start_column - i), board)){
                            return false;
                        }
                    }
                }
                else if (delta_column > 0 && delta_rows < 0){
                    for (int i = 1; i < Math.abs(delta_column); i++){
                        if (!check_empty(translation_list_index(start_row - i, start_column + i), board)){
                            return false;
                        }
                    }
                }
                return true;
            case K:
                return delta_column == 1 || delta_rows == -1 || delta_column == -1 || delta_rows == 1;
            case N:
                return delta_column == 2 && delta_rows == 1 ||
                        delta_column == 2 && delta_rows == -1 ||
                        delta_column == -2 && delta_rows == 1 ||
                        delta_column == -2 && delta_rows == -1 ||
                        delta_column == 1 && delta_rows == 2 ||
                        delta_column == 1 && delta_rows == -2 ||
                        delta_column == -1 && delta_rows == 2 ||
                        delta_column == -1 && delta_rows == -2;
            case P:
                switch (color) {
                    case B:
                        if (delta_column != 0) {
                            if (board.get(rows.indexOf(end.substring(1)) + 1).get(columns.indexOf(end.substring(0, 1)) - 1).get_Piece().getType() != null) {
                                return true;
                            }
                            if (board.get(rows.indexOf(end.substring(1)) + 1).get(columns.indexOf(end.substring(0, 1)) + 1).get_Piece().getType() != null) {
                                return true;
                            }
                        } else {
                            return delta_rows == 1 || delta_rows == 2;
                        }
                        break;
                    case W:
                        if (delta_column != 0) {
                            if (delta_rows == 1) {
                                if (board.get(rows.indexOf(end.substring(1)) - 1).get(columns.indexOf(end.substring(0, 1)) - 1).get_Piece().getColor() != piece.getColor()) {
                                    return true;
                                }
                                if (board.get(rows.indexOf(end.substring(1)) - 1).get(columns.indexOf(end.substring(0, 1)) + 1).get_Piece().getColor() != piece.getColor()) {
                                    return true;
                                }
                            }
                            else{
                                return false;
                            }
                        } else {
                            return delta_rows == -1 || delta_rows == -2;
                        }
                        break;
                }
            case Q:
                break;
            case T:
                break;
        }
        return true;
    }

    private Piece get_Piece_from_position(String position, ArrayList<ArrayList<Square>> board){
        String row = position.substring(1);
        String column = position.substring(0,1);
        String abc = "ABCDEFGH";
        String numbers = "87654321";

        return board.get(numbers.indexOf(row)).get(abc.indexOf(column)).get_Piece();
    }

    private boolean check_empty(String field, ArrayList<ArrayList<Square>> board){
        String row = field.substring(1);
        String column = field.substring(0,1);
        String abc = "ABCDEFGH";
        String numbers = "87654321";
        Piece dummy = board.get(numbers.indexOf(row)).get(abc.indexOf(column)).get_Piece();
        return dummy == null;
    }

    private Color get_color_of_piece(String position, ArrayList<ArrayList<Square>> board){
        String row = position.substring(1);
        String column = position.substring(0,1);
        String abc = "ABCDEFGH";
        String numbers = "87654321";

        return board.get(numbers.indexOf(row)).get(abc.indexOf(column)).get_Piece().getColor();
    }

    private String translation_list_index(int row, int column){
        String abc = "ABCDEFGH";
        String numbers = "87654321";
        return abc.substring(column-1, column)+numbers.substring(row-1, row);
    }

    private boolean is_check(ArrayList<ArrayList<Square>> board,String kings_position,Piece king){
        for(ArrayList list: board){
            for(Object square:list){
                if(square instanceof Square){
                    if (((Square) square).get_Piece().getColor() == Color.B && king.getColor() == Color.W) { //Color Black
                        return move_check(((Square) square).get_Position(), kings_position, board); //returns true if black piece can land there
                    }
                    else{
                        return move_check(((Square) square).get_Position(), kings_position, board);
                    }
                }
            }
        }
    return false;
    }

    private boolean is_suicide(ArrayList<ArrayList<Square>> board, String target){ //target => wo der König hinmöchte
        for(ArrayList list:board){
            for(Object square:list){
                if (square instanceof Square) {
                    if (((Square) square).get_Piece().getColor() == Color.B) { //Color Black
                        return move_check(((Square) square).get_Position(), target, board); //returns true if black piece can land there
                    }
                    else {
                        return move_check(((Square) square).get_Position(), target, board);//returns true if white piece can land there
                    }
                }
            }
        }
    return false;
    }

    private void castle(ArrayList<ArrayList<Square>> board) {
//        boolean condition_T1 = false;
//        boolean condition_T2 = false;
//        boolean condition_K = false;
//        boolean color = false; //false/0 = weiss & true/1 = schwarz
//        for (ArrayList list : board) {
//            for (Object square : list) {
//                if (square instanceof Square) {
//                    if (((Square) square).get_Position().equals("A1")){
//
//                    }
//                }
/*                    if (((Square) square).get_Piece().getColor() == Color.B && ((Square) square).get_Piece().getType() == Type.T
                            && !((Square) square).get_Piece().get_Moved()) {
                        condition_T1 = true;
                    } else if (((Square) square).get_Piece().getColor() == Color.B && ((Square) square).get_Piece().getType() == Type.T
                            && !((Square) square).get_Piece().get_Moved() && condition_T1) {
                        condition_T2 = true;
                    } else if (((Square) square).get_Piece().getColor() == Color.B && ((Square) square).get_Piece().getType() == Type.K
                            && !((Square) square).get_Piece().get_Moved()) {
                        condition_K = true;
                        color = true;
                    }
                    else if (((Square) square).get_Piece().getColor() == Color.W && ((Square) square).get_Piece().getType() == Type.T
                            && !((Square) square).get_Piece().get_Moved()) {
                        condition_T1 = true;
                    } else if (((Square) square).get_Piece().getColor() == Color.W && ((Square) square).get_Piece().getType() == Type.T
                            && !((Square) square).get_Piece().get_Moved() && condition_T1) {
                        condition_T2 = true;
                    } else if (((Square) square).get_Piece().getColor() == Color.W && ((Square) square).get_Piece().getType() == Type.K
                            && !((Square) square).get_Piece().get_Moved()) {
                        condition_K = true;
                        color = false;*/
/*                }
                if(((Square)))
            }
            if (condition_K && condition_T1 && condition_T2 &&! color) { // weiss
                    ; //TODO move white pieces tower and king T[A1]-[C1] K[E1]-[B1] oder T[H1]-[F1] K[E1]-[G1]
                    ;
                }
                else if (condition_K && condition_T1 && condition_T2 && color){
                    ;//TODO move white pieces tower and king T[A8]-[C8] K[E8]-[B8] oder T[H8]-[F8] K[E8]-[G8]
                }*/
//            }
//        }
    }
    private void en_passent(ArrayList<ArrayList<Square>> board){
        ; // TODO LOOOS
    }

//    public void promotion (ArrayList<ArrayList<Square>> board){
//        if (position.substring(1).equals("1") && Type.P && Color.W){
//            System.out.println("You can choose what your pawn will transform into!");
//            System.out.println("Type in one letter as indicated\n" +
//                    "Queen = Q  , Tower = T, Bishop = B, Knight = N");
//            do_promotion();
//        }
//        else if (position.substring(1).equals("") && Type.P && Color.B){
//            System.out.println("You can choose what your pawn will transform into!");
//            System.out.println("Type in one letter as indicated\n" +
//                    "Queen = Q  , Tower = T, Bishop = B, Knight = N");
//            do_promotion();
//        }
//    }
//
//    public void do_promotion() {
//        String tmp = get_user_input();
//        switch (tmp) {
//            case "Q": // remove pawn from square add queen square
//            case "T": // remove pawn from square add tower square
//            case "B": // remove pawn from square add bishop square
//            case "N": // remove pawn from square add knight square
//        }
//    }
}
