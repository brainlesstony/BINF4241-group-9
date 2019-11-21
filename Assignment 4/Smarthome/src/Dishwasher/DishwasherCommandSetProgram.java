package Dishwasher;
import Interfaces.Command;
public class DishwasherCommandSetProgram implements Command {
    Dishwasher dishwasher;
    public DishwasherCommandSetProgram(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        dishwasher.setProgram();
    }
    @Override
    public String toString(){
        return "[SET PROGRAM]";
    }
}
