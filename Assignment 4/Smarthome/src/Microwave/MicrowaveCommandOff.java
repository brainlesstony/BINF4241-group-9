package Microwave;
import Interfaces.Command;
import Interfaces.Machine;

public class MicrowaveCommandOff implements Command {
    private Machine microwave;

    public MicrowaveCommandOff(Machine the_machine) {
        this.microwave = the_machine;
    }

    public void execute(){
        microwave.off();
    }
}
