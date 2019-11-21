package Microwave;
import Interfaces.Command;
import Threads.MyThread;

public class MicrowaveCommandStartBaking implements Command{
    private Microwave microwave;

    public MicrowaveCommandStartBaking(Microwave microwave){ this.microwave = microwave;}

    @Override
    public void execute(){
        MyThread mt1 = new MyThread(this.microwave.getTimer());
        this.microwave.setRunnable(mt1);
        Thread rt1;

        if (this.microwave.getTimer() != -1 && this.microwave.getTemperature() != -1 && this.microwave.getState() && !this.microwave.getRunning()){
            rt1 = new Thread(mt1, "Microwave");
            this.microwave.setThread(rt1);
            this.microwave.setRunningTrue();
            this.microwave.setStartTime();
            rt1.start();

            this.microwave.setRunningFalse();
        }
    }

    @Override
    public String toString(){
        return "[START BAKING]";
    }
}
