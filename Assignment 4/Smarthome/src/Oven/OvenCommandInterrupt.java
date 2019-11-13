package Oven;

import Interfaces.Command;
import Threads.MyThread;

public class OvenCommandInterrupt implements Command {
    Thread rt1;
    MyThread mt1;
    private Oven oven;

    public OvenCommandInterrupt(Oven oven){ // Tf?
        this.oven = oven;
    }
    @Override
    public void execute() {
        mt1 = null;
        rt1 = null;


    }
}
