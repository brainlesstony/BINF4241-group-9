package Cleaning_Robot;

import Interfaces.Command;

public class Cleaning_RobotCommandCheckBattery implements Command {
    private Cleaning_Robot cleaning_robot;
    public Cleaning_RobotCommandCheckBattery(Cleaning_Robot cleaning_robot){
        this.cleaning_robot = cleaning_robot;
    }
    public void execute(){
        System.out.println("Battery status at: "+cleaning_robot.get_battery_status()+ "%");
    }

    @Override
    public String toString(){
        return "[CHECK BATTERY STATUS]";
    }
}
