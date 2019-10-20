import javax.xml.crypto.dsig.TransformService;
import java.util.ArrayList;

public class Move {
    public boolean move_check(String start,
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
}
