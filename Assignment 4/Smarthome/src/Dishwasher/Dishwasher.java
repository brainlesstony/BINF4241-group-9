package Dishwasher;

import Oven.*; // Das isch wichtig! und Riuchtiig

public class Dishwasher extends Oven{
    private boolean state;
    public Dishwasher(Boolean state){
//        super(); // inheritance
        this.state = state;
    }
    void on(){
        this.state = true;
    }
    void off(){
        this.state = false;
    }
}
