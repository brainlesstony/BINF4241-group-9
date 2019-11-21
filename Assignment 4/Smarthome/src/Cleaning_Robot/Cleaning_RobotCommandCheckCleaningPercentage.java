package Cleaning_Robot;
import Interfaces.Command;
public class Cleaning_RobotCommandCheckCleaningPercentage implements Command{
    private Cleaning_Robot cleaning_robot;
    public Cleaning_RobotCommandCheckCleaningPercentage(Cleaning_Robot cleaning_robot){
        this.cleaning_robot = cleaning_robot;
    }
    public void execute(){
        cleaning_robot.get_cleaning_percentage();
    }
    @Override
    public String toString(){
        return "[CURRENT CLEANING PERCENTAGE]";
    }
}
