import Cleaning_Robot.*;
import Dishwasher.*;
import Microwave.*;
import Oven.*;
import Washing_Machine.*;
import Interfaces.*;
import java.util.ArrayList;

public class Remote {
    private ArrayList<Command> machine_with_his_commands;
    private Machine which_machine;

    public Remote(Machine the_machine) {
        machine_with_his_commands = new ArrayList<Command>();
        which_machine = the_machine;

        if (which_machine.getClass().isInstance(Cleaning_Robot.class)){
            //----------Cleaning Robot------------//
            machine_with_his_commands.add((Command) new Cleaning_RobotCommandOff(which_machine));
            machine_with_his_commands.add((Command) new Cleaning_RobotCommandOn(which_machine));
            machine_with_his_commands.add((Command) new Cleaning_RobotSetTimer(which_machine));
            //------------------------------------//
        }
        else if (which_machine.getClass().isInstance(Dishwasher.class)){
            machine_with_his_commands.add((Command) new DishwasherCommandOff(which_machine));
            machine_with_his_commands.add((Command) new DishwasherCommandOn(which_machine));

        }
        else if (which_machine.getClass().isInstance(Microwave.class)){
            machine_with_his_commands.add((Command) new MicrowaveCommandOff(which_machine));
            machine_with_his_commands.add((Command) new MicrowaveCommandOn(which_machine));

        }
    }


}
