package Dishwasher;
import Interfaces.Command;
import Interfaces.Machine;

public class DishwasherCommandOff implements Command {
    private Machine dishwasher;

    public DishwasherCommandOff(Machine the_machine) {
        this.dishwasher = the_machine;
    }

    public void execute(){
        dishwasher.off();
    }
}
