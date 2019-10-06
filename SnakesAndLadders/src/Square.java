public class Square {
    public Square(int position_square) { // class Constructor. Every object of Square is initialized with those statements.
        int position = position_square;
        boolean isLadder = false;
        boolean isSnake = false;
        boolean isFirst = false;
        boolean isLast = false;
        boolean isOccupied = false;
        Player player; // every Square object will be initilazied with a player object. is this ok?
    }
    public void get_player() {
        return player;
    }
     public void changeState() {
         if (this.isOccupied){
             isOccupied = false;
         }
         else {
             isOccupied = false;
         }
    }
}
