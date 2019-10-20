public class Rules {
    private Board board;

    public Rules(Board b) {
        board = b;
    }

    public void is_check(Piece king) {
        //TODO IDEA Iterate through the whole board and check all possible moves
        //TODO 4 If a piece threaten the king
    }

    public void is_en_passant(Piece piece) {  //TODO list of previous moves?
        //TODO 1 If pawn moved two then he can be eaten as if he only moved one
    }

    public boolean is_promotion(Piece pawn) {
        return pawn.has_reached_end();
    }

    public boolean is_castle(Piece king, Piece tower) {
        return !king.is_check() && king.is_at_start() && tower.is_at_start();
    }

    public boolean is_suicide(Piece king) {
        return king.new_location().is_check();
    }

    public boolean is_blocked(Piece piece, Board board) {
        return piece.new_location().is_occupied();
    }

    public boolean is_at_start(Piece piece) {
        return piece.current_location() == piece.start_location;
    }
}