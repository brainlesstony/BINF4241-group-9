package Oven;

import Interfaces.Command;
import Threads.MyThread;

public class OvenCommandStartCooking implements Command {
    private Oven oven;

    public OvenCommandStartCooking(Oven oven){ // Tf?
        this.oven = oven;
    }

    @Override
    public void execute() {
        MyThread mt1 = new MyThread(oven.getTimer());
        this.oven.setRunnable(mt1);
        Thread rt1;

        if(oven.getTimer() != -1 && oven.getProgram()!=null && oven.getTemperature()!=-1 && oven.getState()){
            rt1 = new Thread(mt1, "Oven");
            this.oven.setThread(rt1);
            this.oven.setStartTime();
            rt1.start();

            this.oven.setProgramDone();
        }
    }

    @Override
    public String toString(){
        return "[START COOKING]";
    }
}
