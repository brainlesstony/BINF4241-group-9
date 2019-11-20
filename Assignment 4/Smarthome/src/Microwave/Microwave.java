package Microwave;

import Interfaces.Command;

public class Microwave {
    private boolean state;
    private int temperature;
    private int timer;
    private String program;
    public Command[] commandlist ;
    private Command MicrowaveCommandOff;
    private Command MicrowaveCommandOn;
    public Microwave(){
        this.state = false;
        this.MicrowaveCommandOff = new MicrowaveCommandOn(this);
        this.MicrowaveCommandOn = new MicrowaveCommandOff(this);
        this.commandlist = new Command[] {MicrowaveCommandOn};
    }
    public void on(){
        this.state = true;
        this.commandlist = getCommands();
    }
    public void off(){
        this.state = false;
    }
    private Command[] getCommands(){
        return new Command[] {MicrowaveCommandOn,MicrowaveCommandOff};
    }
}
