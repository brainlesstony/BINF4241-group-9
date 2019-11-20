package Dishwasher;

import Interfaces.Command;

public class DishwasherCommandInterrput implements Command {
    private Dishwasher dishwasher;
    public DishwasherCommandInterrput(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }
    public void execute(){
        ;
    }
}
