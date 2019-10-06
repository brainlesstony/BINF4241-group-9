public class Square {
    private int position;
    private boolean isLadder;
    private boolean isSnake;
    private boolean isFirst;
    private boolean isLast;
    private boolean isOccupied;
    private String player_name;
    private String type;
    private int destination;
    protected Square(int position_square) { // class Constructor. Every object of Square is initialized with those statements.
        this.position = position_square;
        this.isLadder = false;
        this.isSnake = false;
        this.isFirst = false;
        this.isLast = false;
        this.isOccupied = false;
        this.player_name = null;
        this.type = "Square";
    }

    //getters
    public int get_position(){
        return this.position;
    }
    public boolean get_isLadder(){
        return this.isLadder;
    }
    public boolean get_isSnake(){
        return this.isSnake;
    }
    public boolean get_isFirst(){
        return this.isFirst;
    }
    public boolean get_isLast(){
        return this.isLast;
    }
    public boolean get_isOccupied(){
        return this.isOccupied;
    }
    public String get_playername(){
        return this.player_name;
    }
    public String get_type(){
        return this.type;
    }
    public int get_destination(){
        return this.destination;
    }

    //setters
    public void set_position(int new_position){
        this.position = new_position;
    }
    public void set_isLadder(boolean status){
        this.isLadder = status;
    }
    public void set_isSnake(boolean status){
        this.isSnake = status;
    }
    public void set_isFirst(boolean status){
        this.isFirst = status;
    }
    public void set_isLast(boolean status){
        this.isLast = status;
    }
    public void set_isOccupied(boolean status){this.isOccupied = status;}
    public void set_playername(String new_playername) {this.player_name = new_playername;}
    public void set_type(String new_type) {this.type = new_type;}


    @Override
    public String toString(){
        return "[Position: " + Integer.toString(this.position) + ", Type: " + this.type + ", Player: " + this.player_name + "]";
    }
}

