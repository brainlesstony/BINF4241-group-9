public class Square {
    private Square() { // class Constructor. Every object of Square is initialized with those statements.
        public boolean isLadder = False;
        public boolean isSnake = False;
        public boolean isFirst = False;
        public boolean isLast = False;
        public boolean isOccupied = False;
        public Player player; // every Square object will be initilazied with a player object. is this ok?
    }
    public static get_player() {
        return player;
    }
     public void changeState() {
         if (this.isOccupied){
             isOccupied = False;
         }
         else {
             isOccupied = True;
         }
    }
}
