public class Player {
    String name;
    int onSquare;

    Player(String name_user){ // each Player will be initialized with a name (probably user input) and on which square the player is
        String name = name_user;
        int onSquare = 1;
    }

    public String get_name(){
        return this.name;
    }

    public int get_onsquare(){
        return this.onSquare;
    }

    public void move_forward(int steps){
        this.onSquare += steps;
    }



}
