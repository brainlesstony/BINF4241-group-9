package Microwave;

import Interfaces.Command;

public class Microwave {
    private boolean state;
    private int temperature;
    private int timer;

    private boolean running;
    private Command[] Commandlist ;
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
        this.temperature = -1;
        this.timer = -1;
        this.running = false;
    }

    @Override
    public String toString(){
        String state;

        if (this.running) {
            state = "Running";
        }
        else{
            state = "Not Running";
        }

        return "Appliance: Microwave\nState: " + state + "\nTemperature: " + temperature;
    }
    private Command[] getCommands(){
        return new Command[] {MicrowaveCommandOn,MicrowaveCommandOff};
    }

    // SETTERS

    void setTimer(int i){
        this.timer = i;
    }

    void setTemperature(int i){this.temperature = i;}

    public boolean getState(){return this.state;}
}
