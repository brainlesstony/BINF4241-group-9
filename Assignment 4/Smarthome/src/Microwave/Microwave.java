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
//        super(); // inheritance
        this.state = false;
        this.Commandlist = new Command[] {MicrowaveCommandOn};
    }
    public void on(){
        this.state = true;
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
    public Command[] getCommands(){
        return this.Commandlist = new Command[] {MicrowaveCommandOn,MicrowaveCommandOff};
    }

    // SETTERS

    void setTimer(int i){
        this.timer = i;
    }

    void setTemperature(int i){this.temperature = i;}

    public boolean getState(){return this.state;}
}
