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

    public void on() {
        this.state = true;
        System.out.println("Cleaning Robot is turned on.");
    }

    public void off() {
        this.state = false;
        System.out.println("Cleaning Robot is turned off.");
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

    private void return_toBase() {
        this.inBase = true;
    }

    int get_battery_status() {
        return this.battery_status;
    }

    float get_cleaning_percentage() {
        cleaning_percentage = elapsed - timer;
        return cleaning_percentage;
    }

    void start_cleaner() {
        if (get_battery_status() == 100 && inBase) {
            System.out.println("Started the vacuum cleaner.");
            MyThread mt1 = new MyThread(timer);
            runnable = mt1;
            Thread rt1;
            rt1 = new Thread(mt1, "Microwave");
            this.thread = rt1;
            this.inBase = false;
            this.setSTime();
            this.setETime();
            rt1.start();
            return_toBase();

        } else {
            System.out.println("Battery status too low.");
        }
    }
}