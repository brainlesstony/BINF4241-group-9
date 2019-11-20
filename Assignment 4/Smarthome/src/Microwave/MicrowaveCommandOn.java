package Microwave;
import Interfaces.Command;
import Interfaces.Machine;

public class MicrowaveCommandOn implements Command {
    private Microwave microwave;
    public MicrowaveCommandOn(Microwave microwave){
        this.microwave = microwave;
    }
    public void execute(){
        microwave.on();
    }
}
