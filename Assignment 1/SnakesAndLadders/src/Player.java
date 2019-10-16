public class Player {
    String name;
    private int onSquare;

    Player(String name_user){ // each Player will be initialized with a name (probably user input) and on which square the player is
        name = name_user;
        this.onSquare = 0;
        
    }

    public String get_name(){
        return this.name;
    }

    public int get_pos(){
        return this.onSquare;

    }

    public void set_position(int position){
        this.onSquare = position;
    }




}
