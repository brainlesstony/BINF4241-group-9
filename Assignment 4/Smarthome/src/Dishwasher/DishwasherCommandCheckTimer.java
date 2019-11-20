package Dishwasher;
import Interfaces.Command;
public class DishwasherCommandCheckTimer implements Command{
    private Dishwasher dishwasher;
    public DishwasherCommandCheckTimer(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }
    public void execute(){
        this.dishwasher.checktime();
    }
}
