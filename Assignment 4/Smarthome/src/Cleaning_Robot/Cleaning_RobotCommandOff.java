package Cleaning_Robot;
import Interfaces.Command;
import Interfaces.Machine;

public class Cleaning_RobotCommandOff implements Command {

    private Machine cleaning_robot;

    public Cleaning_RobotCommandOff(Machine cleaning_robot){
        this.cleaning_robot = cleaning_robot;
    }

    public void execute(){
        cleaning_robot.off();
    }
}
