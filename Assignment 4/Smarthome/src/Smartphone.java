import Cleaning_Robot.Cleaning_Robot;
import Dishwasher.Dishwasher;
import Interfaces.Command;
import Interfaces.Machine;
import Microwave.Microwave;
import Oven.Oven;
import Washing_Machine.Washing_Machine;


import java.util.ArrayList;

public class Smartphone {
    //---------all machines----------//
    Oven oven;
    Washing_Machine washing_machine;
    Microwave microwave;
    Cleaning_Robot cleaning_robot;
    Dishwasher dishwasher;

    //---------the machine list-----------//
    ArrayList<Machine> machine_list;

    //---------each machine gets a virtual remote-------//
    Remote oven_remote;
    Remote cleaning_robot_remote;

    public Smartphone() {
        Oven oven = new Oven();
        Washing_Machine washing_machine = new Washing_Machine();
        Microwave microwave = new Microwave();
        Cleaning_Robot cleaning_robot = new Cleaning_Robot();
        Dishwasher dishwasher = new Dishwasher();

    }

    public void setOnCommand(int i, Command c) {
        onSlots[i] = c; }

    /*
public class Smartphone {
    public Command[] listofcommands = new Command[50];

    Smartphone() {
        Command noCommand = new NoCommand();
        for (int i = 0; i<50; i++) {
            listofcommands[i] = noCommand;
        }
    }
    */

    public void setCommand(int i, Command c) {
        listofcommands[i] = c;
    }

    public void pressButton(int buttonNum) {
        listofcommands[buttonNum].execute();
    }

    void getCommands(Cleaning_Robot cleaning_robot, Dishwasher dishwasher, Oven oven, Microwave microwave, Washing_Machine washing_machine) {
        int i = 0;
        for (Command each_command : cleaning_robot.commandlist) {
            setCommand(i, each_command);
            i++;
        }
        for (Command each_command : dishwasher.commandlist) {
            setCommand(i, each_command);
            i++;
        }
        for (Command each_command : oven.commandlist) {
            setCommand(i, each_command);
            i++;
        }
        for(Command each_command: microwave.commandlist) {
            setCommand(i, each_command);
            i++;
        }
        for(Command each_command: washing_machine.commandlist) {
            setCommand(i, each_command);
            i++;
        }
    }
}

