package Dishwasher;
import Interfaces.Command;
public class DishwasherCommandOff implements Command {
    private Dishwasher dishwasher;
    public void execute(){dishwasher.off();
    }
}
