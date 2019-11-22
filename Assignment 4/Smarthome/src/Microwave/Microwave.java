package Microwave;

import Interfaces.Command;
import Threads.MyThread;

import java.util.Scanner;

public class Microwave {
    public boolean state;
    private int temperature;
    private int timer;
    private Thread thread;
    private  Runnable runnable;
    private boolean running;
    private long startTime;

    public Microwave(){
        this.state = false;
        this.temperature = -1;
        this.timer = -1;
    }
    public void on(){
        this.state = true;
    }
    public void off(){

        if(!getState()){
            state = false;
            temperature = -1;
            timer = -1;
            running = false;
        }
        else{
            System.out.println("Microwave must finish first!");
        }
    }

    @Override
    public String toString(){

        String state;

        if (this.state) {
            state = "On";
        }
        else{
            state = "Off";
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

    void setTemperature() {
        if (!this.state) {
            System.out.println("Can not set temperature. Microwave is off");
        } else {
            if (this.running) {
                System.out.println("Can not set temperature. Microwave is running");
            } else {
                System.out.println("Set Temperature (100-300): ");
                Scanner in = new Scanner(System.in);

                String answer = in.nextLine();
                boolean isAllDigit = true;
                for (int i = 0; i < answer.length(); i++) {
                    char character = answer.charAt(i);
                    if (!Character.isDigit(character)) {
                        isAllDigit = false;
                        break;
                    }
                }

                if (isAllDigit) {
                    int temperature = Integer.parseInt(answer);
                    if (temperature >= 100 && temperature <= 300) {
                        this.temperature = temperature;
                    } else {
                        System.out.println("Temperature too high or too low!");
                    }
                } else {
                    System.out.println("Input not allowed! Temperature is not valid!");
                }
            }
        }
    }

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

    void setTimer() {
        if (!this.state) {
            System.out.println("Can not set timer. Microwave is off");
        } else {
            if (this.running) {
                System.out.println("Can not set timer. Microwave if running");
            } else {
                System.out.println("Set Timer: ");
                Scanner in = new Scanner(System.in);
                String answer = in.nextLine();
                boolean isAllDigit = true;

                for (int i = 0; i < answer.length(); i++) {
                    char character = answer.charAt(i);
                    if (!Character.isDigit(character)) {
                        isAllDigit = false;
                        break;
                    }
                }

                if (isAllDigit) {
                    int timer = Integer.parseInt(answer);
                    this.timer = (timer * 1000);
                } else {
                    System.out.println("Timer Input is not valid");
                }
            }
        }
    }

    void checkTimer(){
        if (!getState()){
            System.out.println("Can not check time because Microwave is off");
        }else {
            if (getRunning()) {
                System.out.println("Time left: " + (System.currentTimeMillis() - getStartTime()));
            } else {
                System.out.println("Microwave isn't active. Last active timer was: " + getTimer());
            }
        }
    }

    void interrupt(){
        runnable = null;
        thread = null;

        this.runnable = new MyThread();
        this.thread = new Thread(runnable, "Microwave");

        setRunningFalse();
    }

    void startBaking(){
        if (!this.state){
            System.out.println("Can not start baking. Microwave is off");
        }else {
            if (this.running) {
                System.out.println("Can not start baking. Microwave is running");
            } else {
                if (this.temperature == -1 | this.timer == -1) {
                    System.out.println("Set temperature and/or timer first before baking");
                } else {
                    MyThread mt1 = new MyThread(getTimer());
                    setRunnable(mt1);
                    Thread rt1;

                    if (getTimer() != -1 && getTemperature() != -1 && getState() && !getRunning()) {
                        rt1 = new Thread(mt1, "Microwave");
                        setThread(rt1);
                        setRunningTrue();
                        setStartTime();
                        System.out.println("Started baking in the microwave");
                        rt1.start();
                        System.out.println("Finished baking in the microwave");
                        setRunningFalse();
                    }

                }
            }

        }
    }
}
