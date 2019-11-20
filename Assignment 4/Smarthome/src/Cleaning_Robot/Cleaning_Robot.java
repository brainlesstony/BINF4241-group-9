package Cleaning_Robot;

import Interfaces.Command;

public class Cleaning_Robot {
    private boolean state;
    public Command[] commandlist;
    private Command Cleaning_RobotCommandOff;
    private Command Cleaning_RobotCommandOn;
    private Command Cleaning_RobotSetTimer;
    public Cleaning_Robot(){
        this.state = false;
        this.Cleaning_RobotCommandOn = new Cleaning_RobotCommandOn(this);
        this.Cleaning_RobotCommandOff = new Cleaning_RobotCommandOff(this);
        this.Cleaning_RobotSetTimer = new Cleaning_RobotSetTimer(this);
        this.commandlist = new Command[]{Cleaning_RobotCommandOn};
    }
    void on(){
        this.state = true;
        this.commandlist = getCommands();
    }
    void off(){
        this.state = false;
    }
    private Command [] getCommands(){
        return new Command[]{Cleaning_RobotCommandOn,Cleaning_RobotCommandOff,Cleaning_RobotSetTimer};
    }
}
