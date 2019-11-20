package Oven;

import Interfaces.Command;

enum Program_oven{Grill, Ventilated, Normal, Off}

public class Oven {
    private boolean power;
    private int temperature;
    private int timer;
    private Program_oven program;
    private Thread thread;
    private Runnable runnable;
    public Command[] commandlist ;
    private Command OvenCommandInterrupt;
    private Command OvenCommandOff;
    private Command OvenCommandOn;
    private Command OvenCommandSetProgram;
    private Command OvenCommandSetTemperature;
    private Command OvenCommandSetTimer;
    private Command OvenCommandCheckTimer;
    private Command OvenCommandStartCooking;

    public Oven() {
        this.power = false;
        this.program = Program_oven.Off;
        this.OvenCommandOn = new OvenCommandOn(this);
        this.OvenCommandOff = new OvenCommandOff(this);
        this.OvenCommandInterrupt = new OvenCommandInterrupt(this);
        this.OvenCommandSetProgram = new OvenCommandSetProgram(this);
        this.OvenCommandSetTemperature = new OvenCommandSetTemperature(this);
        this.OvenCommandSetTimer = new OvenCommandSetTimer(this);
        this.OvenCommandCheckTimer = new OvenCommandCheckTimer(this);
        this.OvenCommandStartCooking = new OvenCommandStartCooking(this);

        this.commandlist = new Command[]{OvenCommandOn};
    }

    void on() { //package-private
        this.power = true;
//        this.commandlist = getCommands();
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
    String getProgram() {
        return program.toString();
    }

    int getTimer() {
        return this.timer;
    }

    int getTemperature() {
        return this.temperature;
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
    private Command[] getCommands() {
        return new Command [] {this.OvenCommandCheckTimer,this.OvenCommandInterrupt,this.OvenCommandOff,this.OvenCommandOn,this.OvenCommandSetProgram,this.OvenCommandSetTemperature,this.OvenCommandSetTimer,this.OvenCommandStartCooking};
    }

}