package Microwave;

import Interfaces.Command;
import Threads.MyThread;

public class MicrowaveCommandInterrupt implements Command {
    Thread rt1;
    MyThread mt1;
    private Microwave microwave;

    public MicrowaveCommandInterrupt(Microwave microwave){
        this.microwave = microwave;
    }

    public void execute(){
        this.mt1 = null;
        this.rt1 = null;

        this.mt1 = new MyThread();
        this.rt1 = new Thread(mt1, "Microwave");

        this.microwave.setRunningFalse();
    }

    @Override
    public String toString(){
        return "[INTERRUPT]";
    }
}
