package Washing_Machine;
import Threads.MyThread;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Washing_Machine {
    private String myProgram;
    private boolean state;
    private boolean washing;
    private String degree;
    private Thread thread;
    private Runnable runnable;
    private int timer;

    public Washing_Machine(){
        this.washing = false;
        this.timer = 0;
        this.myProgram = "None";
        this.state = false;
        this.degree = "0";
    }

    void on(){
        this.state = true;
    }
    void off(){
        if (this.washing){
            System.out.println("Can not turn off because the machine is still washing your clothes.");
            // do not change state while washing
        }else {
            this.state = false;
        }
    }
    private String getProgram(){
        return myProgram;
    }

    void setProgram(){
        if (!this.state){
            System.out.println("Can not set Program. Machine is off");
        }else{
            if (this.washing){
                System.out.println("Machine is currently washing. Can not set new program");
            }else{
                System.out.println("Select a program [Double_Rinse,Intense,Quick,Spin]");
                System.out.println("Input a letter (to choose a program type the first capital letter e.g. D for Double_Rinse");
                String program = get_user_input();
                String regex = "[DIQS]";
                Pattern pattern = Pattern.compile(regex);
                while (!program.matches(regex)) {
                    System.out.println("Invalid letter. Input should be an the first upper case letter of a program name.\n" +
                            "Try again: ");
                    program = getProgram();
                }
                switch (program) {
                    case "D":
                        this.myProgram = "Double_Rinse";
                        this.timer = 20;
                        // startProgram(); user should just set the program but this method should not start it.
                        break;
                    case "I":
                        this.myProgram = "Intense";
                        this.timer = 10;
                        break;
                    case "Q":
                        this.myProgram = "Quick";
                        this.timer = 5;
                        break;
                    case "S":
                        this.myProgram = "Spin";
                        this.timer = 15;
                        break;
                }
            }
        }
    }

    void setDegree(){
        if (!this.state){
            System.out.println("Machine is not on.");
        }
        else {
            if (this.washing) {
                System.out.println("Machine is currently washing. Can not set degree");
            }
            else{
                System.out.println("Select a degree 15/30/45/60/90 for the washing machine");
                String degree_fu = get_user_input();
                String regex = "(15)|(30)|(45)|(60)|(90)";
                Pattern pattern = Pattern.compile(regex);
                while (!degree_fu.matches(regex)) {
                    System.out.println("Input not valid. Input should be 15/30/45/60/90.\n" +
                            "Try again: ");
                    degree_fu = get_user_input();
                }
                this.degree = degree_fu;
            }
        }

    }

    void startProgram(){
        if (!this.state){
            System.out.println("Can not start machine because it is off");
        }else {
            if (this.washing){
                System.out.println("Machine is already washing");
            }else {
                if (this.myProgram.equals("None") | (this.degree.equals("0"))){
                    System.out.println("Please set a program first and/or a degree.");
                }else {
                    System.out.println("Machine is washing.");
                    this.runnable = new MyThread(this.timer * 1000);
                    Thread rt1;
                    rt1 = new Thread(runnable, this.myProgram);
                    this.thread = rt1;
                    washing = true;
                    rt1.start();
                    washing = false;
                }
            }
        }
    }
    //--------------Help methods------------//
    private String get_user_input(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public String toString(){
        String state;
        if (this.state){
            state = "On";
        }else{
            state = "Off";
        }
        return "Appliance: Washing_Machine | State: " + state + " | Program: " + myProgram + " | Temperature: " + this.degree;
    }
}
