package Cleaning_Robot;
import Interfaces.Command;
import Interfaces.Machine;


public class Cleaning_RobotSetTimer implements Command {
    private Cleaning_Robot cleaning_robot;

    public Cleaning_RobotSetTimer(Cleaning_Robot cleaning_robot){
        this.cleaning_robot = cleaning_robot;
    }

    public void execute() {
        cleaning_robot.setTimer();
    }
}


