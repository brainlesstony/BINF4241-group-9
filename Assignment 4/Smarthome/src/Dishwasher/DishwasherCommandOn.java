package Dishwasher;
import Interfaces.Command;

public class DishwasherCommandOn implements Command {
    private Dishwasher dishwasher;
    public DishwasherCommandOn(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        dishwasher.on();
    }
}
