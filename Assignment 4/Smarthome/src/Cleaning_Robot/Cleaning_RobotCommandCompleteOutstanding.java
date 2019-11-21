package Cleaning_Robot;
import Interfaces.Command;
public class Cleaning_RobotCommandCompleteOutstanding implements Command{
    private Cleaning_Robot cleaning_robot;
    public Cleaning_RobotCommandCompleteOutstanding(Cleaning_Robot cleaning_robot){
        this.cleaning_robot = cleaning_robot;
    }
    public void execute(){
        cleaning_robot.complete_outstanding();
    }
}
