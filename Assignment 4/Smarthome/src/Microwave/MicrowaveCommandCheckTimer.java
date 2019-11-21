package Microwave;
import Interfaces.Command;

public class MicrowaveCommandCheckTimer implements Command {
    private Microwave microwave;

    public MicrowaveCommandCheckTimer(Microwave microwave){
        this.microwave = microwave;
    }

    public void execute(){

        if(this.microwave.getRunning()){
            System.out.println("Time left: " + (System.currentTimeMillis() - this.microwave.getStartTime()));
        }
        else {
            System.out.println("Microwave isn't active. Last active timer was: " + this.microwave.getTimer());
        }
    }

    @Override
    public String toString(){
        return "[CHECK TIMER]";
    }
}
