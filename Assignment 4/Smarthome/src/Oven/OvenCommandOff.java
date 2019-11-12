package Oven;
import Interfaces.Command;
public class OvenCommandOff implements Command {
    private Oven oven;
    public void execute(){
        oven.off();
    }
}
