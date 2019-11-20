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
        this.mt1 = null;
        this.rt1 = null;

        this.mt1 = new MyThread();
        this.rt1 = new Thread(mt1, "Oven");

        this.oven.setProgramNull();

    }
}
