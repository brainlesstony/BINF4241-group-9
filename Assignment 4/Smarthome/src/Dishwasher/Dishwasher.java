package Dishwasher;

import Threads.MyThread;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Dishwasher {
    private boolean state;
    private boolean washing;
    private Thread thread;
    private Runnable runnable;
    private int timer;
    private long startTime;
    String myProgram;
    private int stopped;

    public Dishwasher(){
        this.state = false;
        this.washing = false;
        this.timer = -1;
        this.myProgram = "None";
    }

    void on(){
        this.state = true;
        setProgram();
    }

    void off(){
        if(washing){
            System.out.println("Can not turn dishwasher off, because it is washing right now.");
        }
        this.state = false;
    }

    void stop(){
        stopped++;
        runnable = null;
        thread = null;

        timer = (int)  ((startTime+ timer*1000)  - System.currentTimeMillis()/1000);

    }

    void checktime(){
        if (!this.state){
            System.out.println("Can not check time. Dishwasher is off.");
        }else {
            if (!washing && timer == -1) {
                System.out.println("Select a program for the duration time or start the dishwasher to see the time remaining");
            } else if (!washing) {
                System.out.println("The required time for the program " + myProgram + "is " + timer);
            } else {
                System.out.println("Time left: " + (System.currentTimeMillis() - startTime));
            }
        }
    }
    @Override
    public String toString(){
        String stat;

        if (this.state) {
            stat = "On";
        }
        else{
            stat = "Off";
        }

        return "Appliance: Dishwasher | State: " + stat + " | Program: " + myProgram;
    }

    void setProgram() {
        if (!this.state){
            System.out.println("Can not set Program. Dishwasher is off");
        }else{
            if (this.washing){
                System.out.println("Can not set Program. Dishwasher is washing right now");
            }else{
                System.out.println("Choose one of the following Programs. Type the name:");
                System.out.println(("[Glasses]  [Plates]  [Pans]  [Mixed]  [Quick]"));
                String program = get_user_input();
                String regex = "(Glasses)|(Plates)|(Pans)|(Mixed)|(Quick)";
                Pattern pattern = Pattern.compile(regex);
                while (!program.matches(regex)) {
                    System.out.println("Invalid input. Name required.\n" +
                            "Try again: ");
                    program = get_user_input();
                }
                switch (program){
                    case "Glasses":
                        this.myProgram = "Glasses";
                        this.timer = 20;
                    case "Plates":
                        this.myProgram = "Plates";
                        this.timer = 25;
                    case "Pans":
                        this.myProgram = "Pans";
                        this.timer = 32;
                    case "Mixed":
                        this.myProgram = "Mixed";
                        this.timer = 45;
                    case "Quick":
                        this.myProgram = "Quick";
                        this.timer = 15;
                }
            }
        }
    }

    void startProgram(){
        if (timer == -1){
            System.out.println("Sorry, make sure to select a program before you start the dishwasher");
        }
        if (stopped >= 1){

            this.runnable = new MyThread(this.timer * 1000);
            Thread rt1;
            rt1 = new Thread(runnable,this.myProgram);
            this.thread = rt1;
            this.washing = true;
            setStartTime();

            rt1.start();

            washing = false;
        }

        this.runnable = new MyThread(this.timer * 1000);
        Thread rt1;
        rt1 = new Thread(runnable,this.myProgram);
        this.thread = rt1;
        this.washing = true;
        setStartTime();
        rt1.start();

        washing = false;
    }

    void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    private String get_user_input(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
