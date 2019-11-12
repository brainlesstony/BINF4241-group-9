package Microwave;
import Interfaces.Command;
public class MicrowaveCommandOff implements Command {
    private Microwave microwave;
    public void execute(){
        microwave.off();
    }
}
