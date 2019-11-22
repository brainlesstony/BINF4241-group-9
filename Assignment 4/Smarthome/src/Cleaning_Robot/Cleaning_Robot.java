package Cleaning_Robot;
import Threads.MyThread;

import java.util.Scanner;

public class Cleaning_Robot{
    private boolean state;
    private int timer;
    private int battery_status;
    private long elapsed;
    private long startTime;
    private long completeTime;
    private float cleaning_percentage;
    private Thread rt1;
    private MyThread mt1;
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

    public void off() {
        if(inBase && !state) {
            System.out.println("I'm already sleeping");
        }
        else {
            mt1 = null;
            rt1 = null;
            state = false;
            inBase = true;
            elapsed = System.currentTimeMillis() - elapsed;
            System.out.println("Returned to Base and turned Cleaning Robot off");
        }
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
            timer = Integer.parseInt(answer);
            timer = timer * 1000; //timer in milli
        } else {
            System.out.println("Timer Input is not valid");
            System.out.println("Timer is set.");
        }
    }


    private void setSTime() {
        startTime = System.currentTimeMillis();
    }

    private void setETime() {
        completeTime = System.currentTimeMillis() + timer;
    }

    void return_toBase() {
        inBase = true;
    }

    int get_battery_status() {
        return battery_status;
    }
    void update_battery_status(){
        battery_status = battery_status-(timer/1000);
    }
    private void charging(){
        if (battery_status == 0) {
            mt1 = new MyThread(100 * 1000);
            rt1 = new Thread(mt1, "Cleaning_Robot");
            inBase = true;
            rt1.start();
            battery_status = 100;
        }else {
            int tmp = 100 - battery_status;
            mt1 = new MyThread(tmp * 1000);
            rt1 = new Thread(mt1, "Cleaning_Robot");
            inBase = true;
            rt1.start();
            battery_status = 100;
            }
    }

    void complete_outstanding(){
        if (inBase && get_battery_status() == 100){
            start_cleaner();
        }
    }

    float get_cleaning_percentage() {
        if (timer != 0 && state) {
            float time = System.currentTimeMillis() - elapsed;
            cleaning_percentage = time / timer;
            return cleaning_percentage;
        }else{
            return cleaning_percentage = 0;
        }
    }

    void start_cleaner() {
        if (timer == 0){
            System.out.println("Set a timer first");
        }
        else if(battery_status == 0){
            System.out.println("Battery status too low.");
        }
        else if (get_battery_status() == 100 && inBase) {
            System.out.println("Started the Cleaning_Robot\n");
            if (timer/1000 > battery_status) {
                run();
                battery_status = timer/1000 - battery_status;
            } else {
                run();
            }
        }
    }

    private void run(){
        int time;
        if (battery_status*1000 > timer){
            time = Math.abs(timer);
        }else {
            time = Math.abs(timer-(battery_status * 1000));
        }
        MyThread mt1 = new MyThread(time);
        rt1 = new Thread(mt1, "Cleaning_Robot");
        inBase = false;
        setSTime();
        setETime();
        elapsed = System.currentTimeMillis();
        state = true;
        rt1.start();
        while (mt1.isRunning()){
            System.out.println("The Cleaning_Robot is running");
        }
        System.out.println("Done with the cleaning");
        state = false;
        update_battery_status();
        return_toBase();
        charging();
    }

    void check_charging_status(){
        if (inBase && battery_status == 0){
            System.out.println("Battery status: " + battery_status + " | Time remaining until full charged: 100 seconds");
        }else if(inBase && battery_status == 100) {
            System.out.println("Battery status: " + battery_status + " | Time remaining until full charged: 0 seconds");
        }else{
            System.out.println("Battery status: " + battery_status + " | Time remaining until full charged: "+ (100-battery_status) +"seconds");
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