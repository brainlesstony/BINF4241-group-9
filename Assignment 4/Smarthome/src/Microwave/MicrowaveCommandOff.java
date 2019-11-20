package Microwave;
import Interfaces.Command;
public class MicrowaveCommandOff implements Command {
    private Microwave microwave;
    public void execute(){

        if(!this.microwave.getState()){
            microwave.off();
        }
        else{
            System.out.println("Microwave must finish first!");
        }
    }
}
