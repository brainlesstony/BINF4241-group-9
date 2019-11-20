package Microwave;

import Interfaces.Command;

public class Microwave {
    private boolean state;
    private int temperature;
    private int timer;
    private Thread thread;
    private  Runnable runnable;
    private boolean running;
    private Command[] Commandlist ;
    private Command MicrowaveCommandOff;
    private Command MicrowaveCommandOn;
    private long startTime;

    public Microwave(){
        this.state = false;
        //this.MicrowaveCommandOff = new MicrowaveCommandOn(this);
        //this.MicrowaveCommandOn = new MicrowaveCommandOff(this);
        //this.commandlist = new Command[] {MicrowaveCommandOn};
    }
    public void on(){
        this.state = true;
        //this.commandlist = getCommands();
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

    // GETTERS
    private Command[] getCommands(){
        return new Command[] {MicrowaveCommandOn,MicrowaveCommandOff};
    }

    int getTimer(){
        return this.timer;
    }

    int getTemperature(){return this.temperature;}

    boolean getState(){return this.state;}

    boolean getRunning(){return this.running;}

    long getStartTime(){return this.startTime;}

    // SETTERS
    void setTimer(int i){
        this.timer = i;
    }

    void setTemperature(int i){this.temperature = i;}

    void setRunnable(Runnable runnable){
        this.runnable = runnable;
    }

    void setThread(Thread mythread){
        this.thread = mythread;
    }

    void setRunningTrue(){
        this.running = true;
    }

    void setRunningFalse(){this.running = false;}

    void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }
}
