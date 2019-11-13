package Oven;
enum Program_oven{Grill, Ventilated, Normal, Off}

public class Oven{
    private boolean state;
    private int temperature;
    private int timer;
    private Program_oven program;
    private Thread thread;
    private Runnable runnable;

    public Oven(){
        this.state = false;
        this.program = Program_oven.Off;
    }

    void on(){ //package-private
        this.state = true;
    }

    void off() {
        this.state = false;
        this.temperature = -1;
        this.timer = -1;
        this.program = Program_oven.Off;

    }

    @Override public String toString(){
        String state;

        if (this.state){
            state="On";
        }
        else{
            state="Off";
        }
        return "Appliance: Oven\nState: " + state + "\nProgram: " + program + "\nTemperature: " + temperature;
    }


    // GETTERS
    String getProgram(){
        return program.toString();
    }

    int getTimer(){
        return this.timer;
    }

    int getTemperature(){
        return this.temperature;
    }




    // SETTERS
    void setProgramGrill(){
        this.program = Program_oven.Grill;
    }

    void setProgramNormal(){
        this.program = Program_oven.Normal;
    }

    void setProgramVentilated(){
        this.program = Program_oven.Ventilated;
    }

    void setTimer(int i){
        this.timer = i;
    }

    void setTemperature(int i){
        this.temperature = i;
    }

    void setThread(Thread mythread){
        this.thread = mythread;
    }

    void setRunnable(Runnable run){
        this.runnable = run;
    }
}
