package Oven;

import Interfaces.Command;
import Threads.MyThread;

import java.util.Scanner;

enum Program_oven{Grill, Ventilated, Normal, Off, Done}


public class Oven {
    public boolean power;
    private int temperature;
    private int timer;
    private Program_oven program;
    private Thread rt1;
    private Runnable mt1;
    private long startTime;

    public Oven() {
        this.power = false;
        this.program = Program_oven.Off;
    }

    void on() { //package-private
        this.power = true;
    }

    void off() {
        if (getProgram() == Program_oven.Done) {
            this.power = false;
            this.temperature = -1;
            this.timer = -1;
            this.program = Program_oven.Off;
        }
        else{
            System.out.println("Program must be finished first!");
        }
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

    void setProgramDone(){
        this.program = Program_oven.Done;
    }

    void setProgramNull(){
        this.program = null;
    }

    void setProgram(){
        System.out.println("Choose one of the following Programs:");
        System.out.println(("[Ventilated]  [Grill]  [Normal]"));

        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();

        switch (answer){
            case "Ventilated":
                program = Program_oven.Ventilated;
                break;
            case "Grill":
                program = Program_oven.Grill;
                break;
            case "Normal":
                program = Program_oven.Normal;
                break;
            default:
                System.out.println("Input not valid. Please enter one the available programs");
        }
    }

    void setTemperature() {
        System.out.println("Set Temperature: ");
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
            if (temperature >= 100&& temperature <=300) {
                this.temperature = temperature;
            }
            else{
                System.out.println("Temperature too high or too low!");
            }
        }
        else{
            System.out.println("Input not allowed! Temperature is not valid!");
        }

    }

    void setThread(Thread mythread) {
        this.rt1 = mythread;
    }

    void setRunnable(Runnable run) {
        this.mt1 = run;
    }

    void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    void setTimer() {
        System.out.println("Set Timer in seconds: ");
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
            this.timer = (1000 * timer);
        } else {
            System.out.println("Timer Input not valid");
        }
    }

    void startCooking() {
        MyThread mt1 = new MyThread(getTimer());
        this.setRunnable(mt1);
        Thread rt1;

        if (getTimer() != -1 && getProgram() != null && getTemperature() != -1 && getState()) {
            rt1 = new Thread(mt1, "Oven");
            this.setThread(rt1);
            this.setStartTime();
            rt1.start();
            System.out.println("Finished cooking in the oven");
            this.setProgramDone();
        }
    }
    void interrupt(){
        this.mt1 = null;
        this.rt1 = null;

        this.mt1 = new MyThread();
        this.rt1 = new Thread(mt1, "Oven");

        setProgramNull();

    }
    void checkTimer(){
        if(getProgram() != Program_oven.Done){
            System.out.println("Time left: " + (System.currentTimeMillis()-getStartTime()));
        }
        else{
            System.out.println("No active program. Last active timer was: " + getTimer());
        }
    }
}