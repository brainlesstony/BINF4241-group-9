package Oven;

public class Oven{
    private boolean state;
    private int temperature;
    private int timer;
    private String program;

    public Oven(Boolean state){
        this.state = false;
    }

    //setters
    void on(){ //package-private
        this.state = true;
    }

    void off() {
        this.state = false;
        this.temperature = -1;
        this.timer = -1;
        this.program = null;

    }

    String getProgram(){
        return this.program;
    }

    void setProgramVentilated(){
        this.program = "Ventilated";
    }

    void setProgramGrill(){
        this.program = "Grill";
    }

    void setProgramNormal(){
        this.program = "Normal";
    }

    void setTimer(int i){
        this.timer = i;
    }

    int getTimer(){
        return timer;
    }

    void setTemperature(int i){
        this.temperature = i;
    }

    int getTemperature(){
        return this.temperature;
    }
}
