package Microwave;
import Interfaces.Command;

public class MicrowaveCommandOn implements Command {
    private Microwave microwave;
    public MicrowaveCommandOn(Microwave microwave){
        this.microwave = microwave;
    }
    public void execute(){
        microwave.on();
    }
}
