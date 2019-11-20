package Oven;
import Interfaces.Command;
public class OvenCommandOn implements Command {
    private Oven oven;

    public OvenCommandOn(Oven oven) { // Tf?
        this.oven = oven;
    }

    public void execute() {
        oven.on();
    }

}
