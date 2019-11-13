package Cleaning_Robot;

public class Cleaning_Robot {
    private boolean state;
    public Cleaning_Robot(){
        this.state = false;
    }
    void on(){
        this.state = true;
    }
    void off(){
        this.state = false;
    }
}
