package Oven;
import Interfaces.Command;
public class OvenCommandOff implements Command {
    private Oven oven;

    public OvenCommandOff(Oven oven){ // Tf?
        this.oven = oven;
    }

    public void execute(){
        oven.off();
    }
}
