package Oven;

import Interfaces.Command;

enum Program_oven{Grill, Ventilated, Normal, Off, Done}


public class Oven {
    private boolean power;
    private int temperature;
    private int timer;
    private Program_oven program;
    private Thread thread;
    private Runnable runnable;
    private long startTime;

    public Oven() {
        this.power = false;
        this.program = Program_oven.Off;
    }

    void on() { //package-private
        this.power = true;
    }

    void off() {
        this.power = false;
        this.temperature = -1;
        this.timer = -1;
        this.program = Program_oven.Off;

    }

    @Override
    public String toString() {
        String state;

        if (this.power) {
            state = "On";
        } else {
            state = "Off";
        }
        return "Appliance: Oven | State: " + state + " | Program: " + program + " | Temperature: " + temperature;
    }


    // GETTERS
    Enum getProgram() {
        return program;
    }

    int getTimer() {
        return this.timer;
    }

    int getTemperature() {
        return this.temperature;
    }

    boolean getState(){
        return this.power;
    }

    long getStartTime(){ return this.startTime;}
    // SETTERS
    void setProgramGrill() {
        this.program = Program_oven.Grill;
    }

    void setProgramNormal() {
        this.program = Program_oven.Normal;
    }

    void setProgramVentilated() {
        this.program = Program_oven.Ventilated;
    }

    void setProgramDone(){
        this.program = Program_oven.Done;
    }

    void setProgramNull(){
        this.program = null;
    }

    void setTimer(int i) {
        this.timer = i;
    }

    void setTemperature(int i) {
        this.temperature = i;
    }

    void setThread(Thread mythread) {
        this.thread = mythread;
    }

    void setRunnable(Runnable run) {
        this.runnable = run;
    }

    void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

}