package Dishwasher;

import Interfaces.Command;

public class Dishwasher{
    private boolean state;
    public Command[] commandlist ;
    private Command DishwasherCommandInterrupt;
    private Command DishwasherCommandOff;
    private Command DishwasherCommandOn;

    public Dishwasher(){
        this.state = false;
        this.DishwasherCommandOn = new DishwasherCommandOn(this);
        this.DishwasherCommandOff = new DishwasherCommandOff(this);
        this.DishwasherCommandInterrupt = new DishwasherCommandInterrput(this);
        this.commandlist = new Command[]{DishwasherCommandOn};
    }

    void on(){
        this.state = true;
        this.commandlist = getCommands();
    }
    void off(){
        this.state = false;
    }

    private Command[] getCommands(){
        return this.commandlist = new Command[]{DishwasherCommandOn,DishwasherCommandInterrupt,DishwasherCommandOff};
    }
}
