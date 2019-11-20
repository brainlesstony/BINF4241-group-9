package Dishwasher;
import Interfaces.Command;
import Interfaces.Machine;

public class DishwasherCommandOn implements Command {
    private Dishwasher dishwasher;
    public DishwasherCommandOn(Machine dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        dishwasher.on();
    }
}
