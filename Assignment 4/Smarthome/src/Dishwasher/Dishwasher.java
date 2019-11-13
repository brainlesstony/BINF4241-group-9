package Dishwasher;

public class Dishwasher{
    private boolean state;
    public Dishwasher(Boolean state){
//        super(); // inheritance
        this.state = state;
    }
    void on(){
        this.state = true;
    }
    void off(){
        this.state = false;
    }
}
