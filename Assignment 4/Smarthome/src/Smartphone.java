import Cleaning_Robot.*;
import Dishwasher.*;
import Microwave.*;
import Oven.*;
import Washing_Machine.*;


import Interfaces.Command;

import java.util.ArrayList;

public class Smartphone {
    //---------all machines----------//
    Oven oven;
    Washing_Machine washing_machine;
    Microwave microwave;
    Cleaning_Robot cleaning_robot;
    Dishwasher dishwasher;


    //---------Command Remote List--------- // (each machine gets a list with its commands objects)
    ArrayList<Command> remote_cleaning_robot;
    ArrayList<Command> remote_dishwasher;
    ArrayList<Command> remote_microwave;
    ArrayList<Command> remote_oven;
    ArrayList<Command> remote_washing_machine;


    public Smartphone() {
        Oven oven = new Oven();
        Washing_Machine washing_machine = new Washing_Machine();
        Microwave microwave = new Microwave();
        Cleaning_Robot cleaning_robot = new Cleaning_Robot();
        Dishwasher dishwasher = new Dishwasher();


        //---------assign each variable an arraylist-------------//
        remote_cleaning_robot = new ArrayList<Command>();
        remote_dishwasher = new ArrayList<Command>();
        remote_microwave = new ArrayList<Command>();
        remote_oven = new ArrayList<Command>();
        remote_washing_machine = new ArrayList<Command>();

        //---------init command list for Cleaning robot-----------//
        remote_cleaning_robot.add(new Cleaning_RobotCommandOff(cleaning_robot));
        remote_cleaning_robot.add(new Cleaning_RobotCommandOn(cleaning_robot));
        remote_cleaning_robot.add(new Cleaning_RobotSetTimer(cleaning_robot));

        //--------init command list for Dishwasher --------------//
        remote_dishwasher.add(new DishwasherCommandCheckTimer(dishwasher));
        remote_dishwasher.add(new DishwasherCommandOff(dishwasher));
        remote_dishwasher.add(new DishwasherCommandOn(dishwasher));
        remote_dishwasher.add(new DishwasherCommandStart(dishwasher));
        remote_dishwasher.add(new DishwasherCommandStop(dishwasher));

        //--------init command list for Microwave ---------------//
        remote_microwave.add(new MicrowaveCommandCheckTimer(microwave));
        remote_microwave.add(new MicrowaveCommandInterrupt(microwave));
        remote_microwave.add(new MicrowaveCommandOff(microwave));
        remote_microwave.add(new MicrowaveCommandOn(microwave));
        remote_microwave.add(new MicrowaveCommandSetTemperature(microwave));
        remote_microwave.add(new MicrowaveCommandSetTimer(microwave));
        remote_microwave.add(new MicrowaveCommandStartBaking(microwave));

        //--------init command list for Oven----------------------//
        remote_oven.add(new OvenCommandCheckTimer(oven));
        remote_oven.add(new OvenCommandInterrupt(oven));
        remote_oven.add(new OvenCommandOff(oven));
        remote_oven.add(new OvenCommandOn(oven));
        remote_oven.add(new OvenCommandSetProgram(oven));
        remote_oven.add(new OvenCommandSetTemperature(oven));
        remote_oven.add(new OvenCommandSetTimer(oven));
        remote_oven.add(new OvenCommandStartCooking(oven));


        //--------init command list for washing machine----------//

        remote_washing_machine.add( new Washing_MachineCommandOff(washing_machine));
        remote_washing_machine.add( new Washing_MachineCommandOn(washing_machine));


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

