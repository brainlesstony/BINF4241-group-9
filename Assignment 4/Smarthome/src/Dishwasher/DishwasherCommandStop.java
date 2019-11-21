package Dishwasher;
import Interfaces.Command;
public class DishwasherCommandStop implements Command {
    private Dishwasher dishwasher;
    public DishwasherCommandStop(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }
    public void execute(){
        this.dishwasher.stop();
    }

    @Override
    public String toString(){
        return "[STOP]";
    }
}
