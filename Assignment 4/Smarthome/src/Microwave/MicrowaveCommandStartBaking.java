package Microwave;
import Interfaces.Command;
import Threads.MyThread;

public class MicrowaveCommandStartBaking implements Command{
    private Microwave microwave;

    public MicrowaveCommandStartBaking(Microwave microwave){ this.microwave = microwave;}

    @Override
    public void execute(){
       microwave.startBaking();
    }

    @Override
    public String toString(){
        return "[START BAKING]";
    }
}
