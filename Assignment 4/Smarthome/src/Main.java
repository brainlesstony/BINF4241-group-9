import Dishwasher.*;
import Interfaces.Command;
import Oven.*;
import Washing_Machine.*;
import Cleaning_Robot.*;
import Microwave.*;

import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        // INIT ALL OBJECTS
        Smartphone smartphone = new Smartphone();
        Cleaning_Robot cleaning_robot = new Cleaning_Robot();
        Dishwasher dishwasher = new Dishwasher();
        Oven oven = new Oven();
        Microwave microwave = new Microwave();
        Washing_Machine washing_machine = new Washing_Machine();
        System.out.println(oven);

        Command ovenOn = new OvenCommandOn(oven);
        Command ovenOff = new OvenCommandOff(oven);
        Command ovenSetProgram = new OvenCommandSetProgram(oven);
        smartphone.setCommand(0,ovenOn);
        smartphone.setCommand(1,ovenOff);
        smartphone.setCommand(2,ovenSetProgram);
        smartphone.pressButton(0);
        smartphone.pressButton(2);
        System.out.println(oven);
        // alles in einer liste

//        smartphone.getCommands(cleaning_robot,dishwasher,oven,microwave,washing_machine);
        System.out.println(Arrays.toString(smartphone.listofcommands));
    }
}
