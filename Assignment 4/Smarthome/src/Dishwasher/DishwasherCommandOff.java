package Dishwasher;
import Interfaces.Command;

public class DishwasherCommandOff implements Command {
    private Dishwasher dishwasher;

    public DishwasherCommandOff(Dishwasher the_machine) {
        this.dishwasher = the_machine;
    }

    public void execute(){
        dishwasher.off();
    }

    @Override
    public String toString(){
        return "[OFF]";
    }
}
