package Microwave;
import Interfaces.Command;

public class MicrowaveCommandCheckTimer implements Command {
    private Microwave microwave;

    public MicrowaveCommandCheckTimer(Microwave microwave){
        this.microwave = microwave;
    }

    public void execute(){
        microwave.checkTimer();
    }

    @Override
    public String toString(){
        return "[CHECK TIMER]";
    }
}
