package Oven;
import Interfaces.Command;

public class Oven{
    private boolean state;
    private int temperature;
    private int timer;
    private String program;

    public Oven(Boolean state){
        this.state = false;
    }

    //setters
    void on(){ //package-private
        this.state = true;
    }

    void off() {
        this.state = false;
    }
}
