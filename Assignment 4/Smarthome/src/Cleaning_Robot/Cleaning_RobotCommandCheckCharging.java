package Cleaning_Robot;
import Interfaces.Command;
public class Cleaning_RobotCommandCheckCharging implements Command{
    private Cleaning_Robot cleaning_robot;
    public Cleaning_RobotCommandCheckCharging(Cleaning_Robot cleaning_robot){
        this.cleaning_robot = cleaning_robot;
    }
    public void execute(){
        ;
    }
}
