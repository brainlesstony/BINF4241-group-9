public class Player {
    String name;
    private int onSquare;

    Player(String name_user){ // each Player will be initialized with a name (probably user input) and on which square the player is
        String name = name_user;
        this.onSquare = 1;
        
    }

    public String get_name(){
        return this.name;
    }

    public int get_onSquare(){
        return this.onSquare;

    }

    public void set_position(int position){
        this.onSquare = position;
    }



}
