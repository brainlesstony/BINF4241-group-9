package Cleaning_Robot;
import Threads.MyThread;

import java.util.Scanner;

public class Cleaning_Robot{
    private boolean state;
    private int timer;
    private int battery_status;
    private int elapsed;
    private long startTime;
    private long completeTime;
    private float cleaning_percentage;
    private Thread thread;
    private Runnable runnable;
    private boolean inBase;

    public Cleaning_Robot() {
        this.state = false;
        this.timer = 0;
        this.battery_status = 100;
        this.elapsed = 0;
        this.inBase = true;
        this.cleaning_percentage = 0;
    }

    public boolean get_state(){
        return this.state;
    }

    public void on() {
        this.state = true;
        System.out.println("Turn Cleaning Robot on.");
    }

    public void off() {
        this.state = false;
        System.out.println("Turn Cleaning Robot off");
    }

    void setTimer() {
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
            this.timer = Integer.parseInt(answer);
        } else {
            System.out.println("Timer Input is not valid");
            System.out.println("Timer is set.");
        }
    }


    private void setSTime() {
        this.startTime = System.currentTimeMillis();
    }

    private void setETime() {
        this.completeTime = startTime + timer * 1000;
    }

    void return_toBase() {
        this.inBase = true;
    }

    int get_battery_status() {
        battery_status = (int) ((System.currentTimeMillis()-startTime) / 1000);
        return battery_status;
    }

    private void charging(){
        if (battery_status == 0) {
            MyThread mt1 = new MyThread(100 * 1000);
            runnable = mt1;
            Thread rt1;
            rt1 = new Thread(mt1, "Cleaning_Robot");
            this.thread = rt1;
            this.inBase = true;
            rt1.start();
            battery_status = 100;
        }else {
            int tmp = 100 - battery_status; //Differenz zur Vollladung
            MyThread mt1 = new MyThread(tmp * 1000);
            runnable = mt1;
            Thread rt1;
            rt1 = new Thread(mt1, "Cleaning_Robot");
            this.thread = rt1;
            this.inBase = true;
            rt1.start();
            battery_status = 100;
            }
    }

    void complete_outstanding(){
        if (this.inBase && this.get_battery_status() == 100){
            start_cleaner();
        }
    }

    float get_cleaning_percentage() {
        elapsed = (int) ((startTime - System.currentTimeMillis())/1000);
        cleaning_percentage = elapsed - timer;
        return cleaning_percentage;
    }

    void start_cleaner() {
        if (get_battery_status() == 100 && inBase) {
            System.out.println("Started the vacuum cleaner.");
            if (timer > battery_status) {
                run();
                battery_status = timer - battery_status;
            }
            else {
                run();
            }
        } else {
            System.out.println("Battery status too low.");
        }
    }

    private void run(){
        MyThread mt1 = new MyThread(battery_status*1000);
        runnable = mt1;
        Thread rt1;
        rt1 = new Thread(mt1, "Cleaning_Robot");
        this.thread = rt1;
        this.inBase = false;
        this.setSTime();
        this.setETime();
        on();
        rt1.start();
        off();
        battery_status = 0;
        return_toBase();
        charging();
    }

    void check_charging_status(){
        if (this.inBase){
            System.out.println("Battery status: " + this.battery_status + " | Time remaining until full charged: 100 seconds");
        }
    }


    @Override
    public String toString(){
        String state;

        if (!this.inBase) {
            state = "Cleaning Robot is running";
        }
        else{
            state = "Cleaning Robot is not Running";
        }

        return "Appliance: Cleaning Robot | State: " + state + " | Cleaning percentage: " + get_cleaning_percentage();
    }
}