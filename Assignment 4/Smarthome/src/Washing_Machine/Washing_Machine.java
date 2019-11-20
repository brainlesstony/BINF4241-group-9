package Washing_Machine;
import Threads.MyThread;
import java.util.Scanner;

public class Washing_Machine {
    private String my_program;
    private boolean state;
    private boolean washing;
    private String degree;
    private Thread thread;
    private Runnable runnable;
    private int timer;
    public Washing_Machine(){
        this.washing = false;
        this.timer = -1;
        this.my_program = "";
        this.state = false;
        this.degree = "0";
    }

    void on(){
        this.state = true;
    }

    void off(){
        if (washing){
            this.state = true; // do not change state while washing
        }else {
            this.state = false;
        }
    }

    private String getProgram(){
        return my_program;
    }
    private String getDegree() {return this.degree;}
    void setProgram(){
        boolean not_done = true;
        while (not_done){
            System.out.println("Select a program [Double_Rinse,Intense,Quick,Spin]");
            Scanner scanner = new Scanner(System.in);
            String program = scanner.nextLine();
            switch(program) {
                case "Double_Rinse":
                    this.my_program = "Double_Rinse";
                    this.timer = 20;
                    startProgram();
                case "Intense":
                    this.my_program = "Intense";
                    this.timer = 10;
                    startProgram();
                case "Quick":
                    this.my_program = "Quick";
                    this.timer = 5;
                    startProgram();
                case "Spin":
                    this.my_program = "Spin";
                    this.timer = 15;
                    startProgram();
                default:
                    System.out.println("Invalid Program");
            }
            not_done = false;
        }
    }
    void setDegree () {
        boolean not_done = true;
        while (not_done) {
            System.out.println("Select a degree 15/30/45/60/90 for the washing machine");
            Scanner scanner = new Scanner(System.in);
            String degree = scanner.nextLine();
            switch (degree) {
                case "15":
                    this.degree = "15";
                    break;
                case "30":
                    this.degree = "30";
                    break;
                case "45":
                    this.degree = "45";
                    break;
                case "60":
                    this.degree = "60";
                    break;
                case "90":
                    this.degree = "90";
                    break;
                default:
                    System.out.println("This degree is not allowed");
                    break;
            }
            not_done = false;
        }
    }
    void startProgram(){
        this.runnable = new MyThread(this.timer);
        Thread rt1;
        rt1 = new Thread(runnable,this.my_program);
        this.thread = rt1;
        washing = true;
        rt1.start();
        washing = false;
    }
}
