package Cleaning_Robot;

import Interfaces.Command;

public class Cleaning_RobotCommandOff implements Command {

    private Cleaning_Robot cleaning_robot;

    public Cleaning_RobotCommandOff(Cleaning_Robot cleaning_robot){
        this.cleaning_robot = cleaning_robot;
    }

    public void execute() {
        cleaning_robot.off();
    }
}
