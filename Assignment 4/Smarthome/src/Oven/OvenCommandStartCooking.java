package Oven;

import Interfaces.Command;
import Threads.MyThread;

public class OvenCommandStartCooking implements Command {
    Oven oven;

    @Override
    public void execute() {
        MyThread mt1 = new MyThread(oven.getTimer());

        Thread rt1;

        long elapsed1 = System.currentTimeMillis();

        if(oven.getTimer() != -1 && oven.getProgram()!=null && oven.getTemperature()!=-1){
            rt1 = new Thread(mt1, "Oven");
            elapsed1 = System.currentTimeMillis();
            rt1.start();
        }


    }
}
