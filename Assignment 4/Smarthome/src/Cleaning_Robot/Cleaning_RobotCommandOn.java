package Cleaning_Robot;

import Interfaces.Command;

public class Cleaning_RobotCommandOn implements Command {
    Cleaning_Robot cleaning_robot;

    public Cleaning_RobotCommandOn(Cleaning_Robot the_cleaning_robot){
        cleaning_robot = the_cleaning_robot;
    }

    public void execute(){
        cleaning_robot.on();
    }

    public String toString(){
        return "[ON]";
    }
}
