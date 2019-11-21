package Microwave;

import Interfaces.Command;

public class Microwave {
    private boolean state;
    private int temperature;
    private int timer;
    private Thread thread;
    private  Runnable runnable;
    private boolean running;
    private long startTime;

    public Microwave(){
        this.state = false;
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
            state = "Microwave is running";
        }
        else{
            state = "Microwave is not Running";
        }

        return "Appliance: Microwave | State: " + state + " | Temperature: " + temperature;
    }

    // GETTERS

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
