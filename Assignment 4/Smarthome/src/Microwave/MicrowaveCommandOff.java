package Microwave;
import Interfaces.Command;
import Interfaces.Machine;

public class MicrowaveCommandOff implements Command {
    private Microwave microwave;

    public MicrowaveCommandOff(Microwave microwave) {
        this.microwave = microwave;
    }

    public void execute(){

        if(!this.microwave.getState()){
            microwave.off();
        }
        else{
            System.out.println("Microwave must finish first!");
        }
    }
}
