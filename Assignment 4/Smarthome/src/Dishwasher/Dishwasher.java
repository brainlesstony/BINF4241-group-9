package Dishwasher;

public class Dishwasher {
    private boolean state;

    public Dishwasher(){
        this.state = false;
    }

    void on(){
        this.state = true;
    }

    void off(){
        this.state = false;
    }

}
