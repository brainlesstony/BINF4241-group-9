package Microwave;
import Oven.*;
public class Microwave extends Oven{
    private boolean state;
    private int temperature;
    private int timer;
    private String program;
    public Microwave(Boolean state){
        this.state = state;
    }

}
