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
    private Command[] Commandlist ;
    private Command OvenCommandInterrupt;
    private Command OvenCommandOff;
    private Command OvenCommandOn;
    private Command SetProgram;
    private Command SetTemperature;
    private Command SetTimer;
    private Command StartCooking;

    public Oven() {
        this.power = false;
        this.program = Program_oven.Off;
        this.Commandlist = new Command[]{OvenCommandOn};
    }

    void on() { //package-private
        this.power = true;
        this.Commandlist = getCommands();
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
        return "Appliance: Oven\nState: " + state + "\nProgram: " + program + "\nTemperature: " + temperature;
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

    //COMMAND LISTS
    public Command[] getCommands() {
        return new Command [] {OvenCommandInterrupt,OvenCommandOff,OvenCommandOn,SetProgram,SetTemperature,SetTimer,StartCooking};
    }

}