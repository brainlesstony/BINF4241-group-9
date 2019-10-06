public class Player {
    Player(String name_user){ // each Player will be initialized with a name (probably user input) and on which square the player is
        String name = name_user;
        int onSquare = 1;
        
    }

    public String get_name(){
        return this.name;
    }

    public String get_onsquare(){
        return onsquare;
    }

    public static void move_forward(steps){
        onboard += steps;
    }



}
