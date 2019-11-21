package Cleaning_Robot;
import Interfaces.Command;

public class Cleaning_RobotCommandStart implements Command {
    private Cleaning_Robot cleaning_robot;

    public Cleaning_RobotCommandStart(Cleaning_Robot cleaning_robot){
        this.cleaning_robot = cleaning_robot;
    }
    public void execute() {
        cleaning_robot.start_cleaner();
    }

}
