package Microwave;
import Interfaces.Command;

public class MicrowaveCommandOff implements Command {
    private Microwave microwave;

    public MicrowaveCommandOff(Microwave microwave) {
        this.microwave = microwave;
    }

    public void execute(){
        microwave.off();
    }

    @Override
    public String toString(){
        return "[OFF]";
    }
}
