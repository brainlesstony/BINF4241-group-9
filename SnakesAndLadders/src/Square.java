import javax.lang.model.type.NullType;

public class Square {
    public Square(String[] args, int position_square) { // class Constructor. Every object of Square is initialized with those statements.
        int position = position_square;
        boolean isLadder = false;
        boolean isSnake = false;
        boolean isFirst = false;
        boolean isLast = false;
        boolean isOccupied = false;
        String player_name = null;
    }
    public String get_player() {
        return player_name;
    }
     public void changeState() {
         if (this.isOccupied){
             isOccupied = false;
         }
         else {
             isOccupied = true;
         }
    }
    public void occupySquare(Player neuer_player){
        player = neuer_player;
    }
}

