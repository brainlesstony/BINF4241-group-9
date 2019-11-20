package Microwave;

import Interfaces.Command;

public class Microwave {
    private boolean state;
    private int temperature;
    private int timer;
    private String program;
    private Command[] Commandlist ;
    private Command MicrowaveCommandOff;
    private Command MicrowaveCommandOn;
    public Microwave(){
//        super(); // inheritance
        this.state = false;
        this.Commandlist = new Command[] {MicrowaveCommandOn};
    }
    public void on(){
        this.state = true;
    }
    public void off(){
        this.state = false;
    }
    public Command[] getCommands(){
        return this.Commandlist = new Command[] {MicrowaveCommandOn,MicrowaveCommandOff};
    }
}
