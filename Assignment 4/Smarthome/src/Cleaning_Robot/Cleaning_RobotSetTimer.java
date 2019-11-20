package Cleaning_Robot;

import Interfaces.Machine;

public class Cleaning_RobotSetTimer {
    private Machine cleaning_robot;

    public Cleaning_RobotSetTimer(Machine cleaning_robot){
        this.cleaning_robot = cleaning_robot;
    }

    public void execute() {
        cleaning_robot.setTimer();
    }


}
