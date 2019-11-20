package Cleaning_Robot;
import Interfaces.Command;
import Interfaces.Machine;

public class Cleaning_RobotCommandOn implements Command {
    private Machine cleaning_robot;

    public Cleaning_RobotCommandOn(Machine cleaning_robot){
        this.cleaning_robot = cleaning_robot;
    }
    public void execute() {
        cleaning_robot.on();
    }

}
