package Dishwasher;
import Interfaces.Command;
public class DishwasherCommandStart implements Command{
    private Dishwasher dishwasher;

    public DishwasherCommandStart(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }
    public void execute(){
        this.dishwasher.startProgram();
    }
}
