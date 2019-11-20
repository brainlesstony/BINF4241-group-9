package Dishwasher;

import Interfaces.Command;

public class Dishwasher{
    private boolean state;
    private Command[] commandlist ;
    private Command DishwasherCommandInterrupt;
    private Command DishwasherCommandOff;
    private Command DishwasherCommandOn;

    public Dishwasher(){
        this.state = false;
        this.commandlist = new Command[]{DishwasherCommandOn};
    }

    void on(){
        this.state = true;
        this.commandlist = getCommands();
    }
    void off(){
        this.state = false;
    }

    public Command[] getCommands(){
        return this.commandlist = new Command[]{DishwasherCommandOn,DishwasherCommandInterrupt,DishwasherCommandOff};
    }
}
