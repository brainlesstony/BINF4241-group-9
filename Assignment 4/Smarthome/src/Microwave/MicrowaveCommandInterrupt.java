package Microwave;

import Interfaces.Command;

public class MicrowaveCommandInterrupt implements Command {
    private Microwave microwave;

    public MicrowaveCommandInterrupt(Microwave microwave){
        this.microwave = microwave;
    }

    public void execute(){
        microwave.interrupt();
    }

    @Override
    public String toString(){
        return "[INTERRUPT]";
    }
}
