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

    public void pressOnButton(int buttonNum) {
        onSlots[buttonNum].execute(); }


}
