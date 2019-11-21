package Cleaning_Robot;
import Interfaces.Command;
import Interfaces.Machine;

public class Cleaning_RobotCommandOff implements Command {

    private Cleaning_Robot cleaning_robot;

    public Cleaning_RobotCommandOff(Cleaning_Robot cleaning_robot){
        this.cleaning_robot = cleaning_robot;
    }

    public void execute(){
        cleaning_robot.return_toBase();
        cleaning_robot.off();
    }
}
