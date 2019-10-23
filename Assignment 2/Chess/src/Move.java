import javax.xml.crypto.dsig.TransformService;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Move {

    public boolean move_check(String start, String end, Board board) {

        if (!board.valid_input(start) | !board.valid_input(end)) { // checks if the input is valid
            return false;
        }

        if (!check_empty(end, board.getBoard())) { // falls auf zielfeld eine Figur mit gleicher Farbe steht
            if (get_color_of_piece(end, board.getBoard()) == get_color_of_piece(start, board.getBoard())) {
                System.out.println("Don't try to capture your own figure. Try again: ");
                return false;
            }
        }
        if (!is_valid_path(start, end, board)){
            System.out.println("This Figure cant make this move. Try again: ");
            return false;
        }
        if (check_path_occupied(start, end, board)) { // checks if the path of the figure is getting blocked
            System.out.println("Blocked. Try again: ");
            return false;
        }
        return true;
    }

//    public boolean can_move(String start,Board board){
//        if (possible_moves(start,board).isEmpty()){ // check if piece can actually move from start position
//            return false;
//        }
//        return true;
//    }


    private ArrayList<ArrayList<Square>> possible_moves (String start, Board board){
        /**
         * @param start takes a specific Figure on the board
         * @param board iterates trough board to any position to get an list of possible moves for that specific Figure
         * @returns possible moves as nested arraylist
         */
        ArrayList<ArrayList<Square>> possible_moves = new ArrayList<>();
        for (ArrayList<Square> arrayList: board.getBoard()){
            for (Square square : arrayList){

                if (!check_path_occupied(start, square.get_Position(), board)) { // This check checks if the path is not blocked
//                    if (!square.get_is_empty()) {
                    if (board.get_Piece_from_position(start).getColor() != board.get_Piece_from_position(start).getColor()) { // This check checks that the opposite color is taken
                        possible_moves.add(get_path(start, square.get_Position(), board));
                        System.out.println(square);
                        }
//                    }
                }
            }
        }
        return possible_moves;
    }

    private Piece get_Piece_from_position(String position, Board board){
        String row = position.substring(1);
        String column = position.substring(0,1);
        String abc = "ABCDEFGH";
        String numbers = "87654321";

        return board.getBoard().get(numbers.indexOf(row)).get(abc.indexOf(column)).get_Piece();
    }

    private boolean check_empty(String field, ArrayList<ArrayList<Square>> board){
        String row = field.substring(1);
        String column = field.substring(0,1);
        String abc = "ABCDEFGH";
        String numbers = "87654321";
        Piece dummy = board.get(numbers.indexOf(row)).get(abc.indexOf(column)).get_Piece();
        return dummy == null;
    }

    public ArrayList<Square> get_path(String start, String end, Board board){
        /**
         * This method draws a path from start to end even if it is a specific path for the specific figure on the start
         * @param start
         * @param end
         * @param board
         * @return ArrayList with Square element
         */
        ArrayList<Square> path_list = new ArrayList<Square>();
        Piece piece = board.get_Piece_from_position(start);
        Type type_of_piece = piece.getType();
        int start_x = translation_string_to_board_row(start);
        int start_y = translation_string_to_board_col(start);
        int end_x = translation_string_to_board_row(end);
        int end_y = translation_string_to_board_col(end);
        switch (type_of_piece){
            case B:
                if (start_x < end_x && start_y < end_y){
                    while (start_x != end_x && start_y != end_y){
                        start_x++;
                        start_y++;
                        if (board.valid_input(translation_list_index(start_x, start_y))){
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                }else if (start_x < end_x && start_y > end_y){
                    while (start_x != end_x && start_y != end_y){
                        start_x++;
                        start_y--;
                        if (board.valid_input(translation_list_index(start_x, start_y))) {
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                }else if ( start_x > end_x && start_y < end_y){
                    while (start_x != end_x && start_y != end_y){
                        start_x--;
                        start_y++;
                        if (board.valid_input(translation_list_index(start_x, start_y))) {
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                }else if (start_x > end_x && start_y > end_y){
                    while (start_x != end_x && start_y != end_y){
                        start_x--;
                        start_y--;
                        if (board.valid_input(translation_list_index(start_x, start_y))) {
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                }
            case T:
                if (start_x == end_x && start_y < end_y){
                    while (start_y != end_y){
                        start_y++;
                        if (board.valid_input(translation_list_index(start_x, start_y))) {
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                }else if (start_x < end_x && start_y == end_y){
                    while (start_x != end_x){
                        start_x++;
                        if (board.valid_input(translation_list_index(start_x, start_y))) {
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                }else if ( start_x == end_x && start_y > end_y){
                    while (start_y != end_y){
                        start_y--;
                        if (board.valid_input(translation_list_index(start_x, start_y))) {
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                }else if (start_x > end_x && start_y == end_y){
                    while (start_x != end_x){
                        start_x--;
                        if (board.valid_input(translation_list_index(start_x, start_y))) {
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                }
            case Q:
                if (start_x < end_x && start_y < end_y){
                    while (start_x != end_x && start_y != end_y){
                        start_x++;
                        start_y++;
                        if (board.valid_input(translation_list_index(start_x, start_y))) {
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                }else if (start_x < end_x && start_y > end_y){
                    while (start_x != end_x && start_y != end_y){
                        start_x++;
                        start_y--;
                        if (board.valid_input(translation_list_index(start_x, start_y))) {
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                }else if ( start_x > end_x && start_y < end_y){
                    while (start_x != end_x && start_y != end_y){
                        start_x--;
                        start_y++;
                        if (board.valid_input(translation_list_index(start_x, start_y))) {
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                }else if (start_x > end_x && start_y > end_y){
                    while (start_x != end_x && start_y != end_y){
                        start_x--;
                        start_y--;
                        if (board.valid_input(translation_list_index(start_x, start_y))) {
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                } else if (start_x == end_x && start_y < end_y){
                    while (start_y != end_y){
                        start_y++;
                        if (board.valid_input(translation_list_index(start_x, start_y))) {
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                }else if (start_x < end_x && start_y == end_y){
                    while (start_x != end_x){
                        start_x++;
                        if (board.valid_input(translation_list_index(start_x, start_y))) {
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                }else if ( start_x == end_x && start_y > end_y){
                    while (start_y != end_y){
                        start_y--;
                        if (board.valid_input(translation_list_index(start_x, start_y))) {
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                }else if (start_x > end_x && start_y == end_y){
                    while (start_x != end_x){
                        start_x--;
                        if (board.valid_input(translation_list_index(start_x, start_y))) {
                            path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                        }
                    }
                }
            case K: // actually one does not need the path of the king bc he just moves one field, but this is important for Scharade.
                if (start_x < end_x && start_y < end_y){
                    start_x++;
                    start_y++;
                    if (board.valid_input(translation_list_index(start_x, start_y))){
                        path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                    }
                }else if (start_x < end_x && start_y > end_y){
                    start_x++;
                    start_y--;
                    if (board.valid_input(translation_list_index(start_x, start_y))) {
                        path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                    }
                }else if ( start_x > end_x && start_y < end_y){
                    start_x--;
                    start_y++;
                    if (board.valid_input(translation_list_index(start_x, start_y))) {
                        path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                    }
                }else if (start_x > end_x && start_y > end_y){
                    start_x--;
                    start_y--;
                    if (board.valid_input(translation_list_index(start_x, start_y))) {
                        path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                    }
                } else if (start_x == end_x && start_y < end_y){
                    start_y++;
                    if (board.valid_input(translation_list_index(start_x, start_y))) {
                        path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                    }
                }else if (start_x < end_x && start_y == end_y){
                    start_x++;
                    if (board.valid_input(translation_list_index(start_x, start_y))) {
                        path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                    }
                }else if ( start_x == end_x && start_y > end_y){
                    start_y--;
                    if (board.valid_input(translation_list_index(start_x, start_y))) {
                        path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                    }
                }else if (start_x > end_x && start_y == end_y){
                    start_x--;
                    if (board.valid_input(translation_list_index(start_x, start_y))) {
                        path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                    }
                }

            case N: // just check if endpoint is free or captureable
                break;
            case P:
                    switch (piece.getColor()) {
                        case B:
                            while (start_y != end_y) {
                                start_y--; // one directly above the pawn
                                if (board.valid_input(translation_list_index(start_x,start_y))){ // for the double jump at start
                                    path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                                }
                            }
                        case W:
                            while (start_y != end_y) {
                                start_y++;
                                if (board.valid_input(translation_list_index(start_x,start_y))) {
                                    path_list.add(board.get_Square_from_position(translation_list_index(start_x, start_y)));
                                }
                            }
                    }
        }
        return path_list;
    }

    public boolean is_valid_path(String start, String end, Board board){
        /**
         * This method is used to calculate a path from start to end. It then decides if it is weather valid
         * for the figure on the start position to walk this path to the end position.
         * @param start eg: A6, B4,
         * @param end dito
         * @param board it need a coordinate system
         * @return boolean if it is a valid path
         */
        Piece piece = board.get_Piece_from_position(start);
        Type type_of_piece = piece.getType();
        int start_x = translation_string_to_board_row(start);
        int start_y = translation_string_to_board_col(start);
        int end_x = translation_string_to_board_row(end);
        int end_y = translation_string_to_board_col(end);
        switch (type_of_piece){
            case B:
                return Math.abs(start_x - end_x) == Math.abs(start_y - end_y); //This statement must holds because the Bishop can only move diagonal.
            case T:
                return start_x == end_x | start_y == end_y; //This statement must holds because the Tower can just move horizontal or vertical
            case Q:
                return Math.abs(start_x - end_x) == Math.abs(start_y - end_y) | start_x == end_x | start_y == end_y; // Queen = Bishop + Tower
            case N:
                return (   (start_x + 1 == end_x && start_y + 2 == end_y) // One of those statements must hold when it is a valid path for Knight.
                        |  (start_x + 2 == end_x && start_y + 1 == end_y)
                        |  (start_x + 2 == end_x && start_y - 1 == end_y)
                        |  (start_x + 1 == end_x && start_y - 2 == end_y)
                        |  (start_x - 1 == end_x && start_y - 2 == end_y)
                        |  (start_x - 2 == end_x && start_y - 1 == end_y)
                        |  (start_x - 2 == end_x && start_y + 1 == end_y)
                        |  (start_x - 1 == end_x && start_y + 2 == end_y)
                );
                // Every 8 possible endpoints of knight is tested.
            case K:
                return     !is_suicide(board, translation_list_index(end_x, end_y), piece) // when king doesn't suicide
                        &  (
                            (start_x  == end_x && start_y + 1  == end_y) // and it moves just around itself
                        |   (start_x + 1 == end_x && start_y + 1 == end_y)
                        |   (start_x + 1 == end_x && start_y == end_y)
                        |   (start_x + 1 == end_x && start_y - 1 == end_y)
                        |   (start_x == end_x && start_y - 1 == end_y)
                        |   (start_x - 1 == end_x && start_y - 1 == end_y)
                        |   (start_x - 1 == end_x && start_y == end_y)
                        |   (start_x - 1 == end_x && start_y + 1 == end_y)
                        |   possible_scharade(piece, board)
                            ); // checks if scharade possible

            case P:
                switch (piece.getColor()){
                    case W:
                        if (start_y + 1 == end_y){ // if the target is one above
                            if (start_x - 1 == end_x | start_x + 1 == end_x) { // one above and left or right
                                if (board.get_Piece_from_position(translation_list_index(end_x, end_y)) != null){
                                    // when left or right target must contain enemy
                                    return board.get_Piece_from_position((translation_list_index(end_x, end_y))).getColor() != Color.W;
                                }else return false;
                            }else return start_x == end_x;
                        }else if (start_y + 2 == end_y & start_x == end_x){
                            return !piece.get_has_moved();
                        }else return false;

                    case B:
                        if (start_y - 1 == end_y){ // if the target is one above
                            if (start_x - 1 == end_x | start_x + 1 == end_x) { // one above and left or right
                                if (board.get_Piece_from_position(translation_list_index(end_x, end_y)) != null){
                                    // when left or right target must contain enemy
                                    return board.get_Piece_from_position((translation_list_index(end_x, end_y))).getColor() != Color.W;
                                }else return false;
                            }else return start_x == end_x;
                        }else if (start_y - 2 == end_y & start_x == end_x){
                            return !piece.get_has_moved();
                        }else return false;
                }
        }

        return false;
    }

    private boolean check_path_occupied(String start, String end_pos, Board board){
        /**
         * @return if the path is blocked or not
         */
        ArrayList<Square> path_list = get_path(start, end_pos, board);
        if (path_list.size() != 0) { path_list.remove(path_list.size() - 1);}  // If an enemy is on the target square (=last element) it is possible to capture it.
        for (Square square : path_list){
            if (square.get_Piece() != null) {
                return true;
            }
        }
        return false;
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
        return abc.substring(row, row+1)+Integer.toString(column+1);
    }

    private int translation_string_to_board_col(String input){
        String row = input.substring(1);
        String numbers = "12345678";
        return numbers.indexOf(row);
    }

    private int translation_string_to_board_row(String input){
        String column = input.substring(0,1);
        String abc = "ABCDEFGH";
        return abc.indexOf(column);
    }

    private boolean is_check(Board board, String kings_position, Piece king){
        for(ArrayList<Square> list: board.getBoard()){
            for (Square square : list){
                if (square.get_Piece().getColor() != king.getColor()){
                    if (move_check(square.get_Position(), kings_position, board)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
 // TODO CHECKMATE METHOD
    public boolean checkmate(Board board, String kings_position, Piece king){
        if (is_check(board, kings_position, king)){
            return true;
        }
        return false; // TODO: need to check first if king in danger
    }

    private boolean is_suicide(Board board, String target, Piece king){ //target => wo der König hinmöchte
        return is_check(board, target, king);
    }

    private boolean possible_scharade(Piece king, Board board){ // nur könig kann scharade ausführen
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
                    ; //TODO move white pieces tower and king T[A1]-[C1] K[E1]-[B1] oder T[H1]-[F1] K[E1]-[G1] STEF
                    ;
                }
                else if (condition_K && condition_T1 && condition_T2 && color){
                    ;//TODO move white pieces tower and king T[A8]-[C8] K[E8]-[B8] oder T[H8]-[F8] K[E8]-[G8] STEF
                }*/
//            }
//        }
        return false;
    }

    private boolean is_en_passent(ArrayList<ArrayList<Square>> board){
        ; // TODO LOOOS STEF LOOOOS
        return false;
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
