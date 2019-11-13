package Cleaning_Robot;

public class Cleaning_RobotCommandOff {

    private Cleaning_Robot cleaning_robot;

    public Cleaning_RobotCommandOff(Cleaning_Robot cleaning_robot){
        this.cleaning_robot = cleaning_robot;
    }

    public void execute() {
        cleaning_robot.off();
    }
}
