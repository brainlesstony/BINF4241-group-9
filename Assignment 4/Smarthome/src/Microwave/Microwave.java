package Microwave;
public class Microwave {
    private boolean state;
    private int temperature;
    private int timer;
    private String program;
    public Microwave(Boolean state){
//        super(); // inheritance
        this.state = state;
    }
    public void on(){
        this.state = true;
    }
    public void off(){
        this.state = false;
    }

}
