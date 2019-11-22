import Cleaning_Robot.*;
import Dishwasher.*;
import Microwave.*;
import Oven.*;
import Washing_Machine.*;

import Interfaces.Command;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Smartphone {
    //---------all machines----------//
    private Oven oven;
    private Washing_Machine washing_machine;
    private Microwave microwave;
    private Cleaning_Robot cleaning_robot;
    private Dishwasher dishwasher;

    //--------machine List----------//
    private ArrayList<Object> machine_list;

    //---------Command Remote List--------- // (each machine gets a list with its commands objects)
    private ArrayList<Command> remote_cleaning_robot;
    private ArrayList<Command> remote_dishwasher;
    private ArrayList<Command> remote_microwave;
    private ArrayList<Command> remote_oven;
    private ArrayList<Command> remote_washing_machine;
    private ArrayList<Command> remote_dishwasherOff;
    private ArrayList<Command> remote_microwaveOff;
    private ArrayList<Command> remote_ovenOff;
    private ArrayList<Command> remote_washing_machineOff;


    public Smartphone() {

        //--------add all machine to a list---------//
        this.oven = new Oven();
        this.washing_machine = new Washing_Machine();
        this.microwave = new Microwave();
        this.cleaning_robot = new Cleaning_Robot();
        this.dishwasher = new Dishwasher();
        machine_list = new ArrayList<Object>();
        machine_list.add(oven);
        machine_list.add(washing_machine);
        machine_list.add(microwave);
        machine_list.add(cleaning_robot);
        machine_list.add(dishwasher);




        //---------assign each remote variable an ArrayList-------------//
        remote_cleaning_robot = new ArrayList<Command>();
        remote_dishwasher = new ArrayList<Command>();
        remote_dishwasherOff = new ArrayList<Command>();
        remote_microwave = new ArrayList<Command>();
        remote_microwaveOff = new ArrayList<Command>();
        remote_oven = new ArrayList<Command>();
        remote_ovenOff = new ArrayList<Command>();
        remote_washing_machine = new ArrayList<Command>();
        remote_washing_machineOff = new ArrayList<Command>();

        //---------init command list for Cleaning robot-----------//
        remote_cleaning_robot.add(new Cleaning_RobotCommandOff(cleaning_robot));
        remote_cleaning_robot.add(new Cleaning_RobotSetTimer(cleaning_robot));
        remote_cleaning_robot.add(new Cleaning_RobotCommandCheckBattery(cleaning_robot));
        remote_cleaning_robot.add(new Cleaning_RobotCommandCheckCharging(cleaning_robot));
        remote_cleaning_robot.add(new Cleaning_RobotCommandCheckCleaningPercentage(cleaning_robot));
        remote_cleaning_robot.add(new Cleaning_RobotCommandCompleteOutstanding(cleaning_robot));
        remote_cleaning_robot.add(new Cleaning_RobotCommandStart(cleaning_robot));

        //--------init command list for DishwasherOff --------------//
        remote_dishwasherOff.add(new DishwasherCommandOn(dishwasher));
        //--------init command list for Dishwasher --------------//
        remote_dishwasher.add(new DishwasherCommandOn(dishwasher));
        remote_dishwasher.add(new DishwasherCommandCheckTimer(dishwasher));
        remote_dishwasher.add(new DishwasherCommandOff(dishwasher));
        remote_dishwasher.add(new DishwasherCommandStart(dishwasher));
        remote_dishwasher.add(new DishwasherCommandStop(dishwasher));
        remote_dishwasher.add(new DishwasherCommandSetProgram(dishwasher));

        //--------init command list for MicrowaveOff ---------------//
        remote_microwaveOff.add(new MicrowaveCommandOn(microwave));
        //--------init command list for Microwave ---------------//
        remote_microwave.add(new MicrowaveCommandOn(microwave));
        remote_microwave.add(new MicrowaveCommandCheckTimer(microwave));
        remote_microwave.add(new MicrowaveCommandInterrupt(microwave));
        remote_microwave.add(new MicrowaveCommandOff(microwave));
        remote_microwave.add(new MicrowaveCommandSetTemperature(microwave));
        remote_microwave.add(new MicrowaveCommandSetTimer(microwave));
        remote_microwave.add(new MicrowaveCommandStartBaking(microwave));

        //--------init command list for OvenOff----------------------//
        remote_ovenOff.add(new OvenCommandOn(oven));
        //--------init command list for Oven----------------------//
        remote_oven.add(new OvenCommandOn(oven));
        remote_oven.add(new OvenCommandCheckTimer(oven));
        remote_oven.add(new OvenCommandInterrupt(oven));
        remote_oven.add(new OvenCommandOff(oven));
        remote_oven.add(new OvenCommandSetProgram(oven));
        remote_oven.add(new OvenCommandSetTemperature(oven));
        remote_oven.add(new OvenCommandSetTimer(oven));
        remote_oven.add(new OvenCommandStartCooking(oven));

        //--------init command list for washing machineOff----------//
        remote_washing_machineOff.add( new Washing_MachineCommandOn(washing_machine));
        //--------init command list for washing machine----------//
        remote_washing_machine.add( new Washing_MachineCommandOn(washing_machine));
        remote_washing_machine.add( new Washing_MachineCommandOff(washing_machine));
        remote_washing_machine.add( new Washing_MachineCommandSetDegree(washing_machine));
        remote_washing_machine.add( new Washing_MachineCommandSetProgram(washing_machine));
        remote_washing_machine.add( new Washing_MachineCommandStart(washing_machine));
    }
    public void run(){
        print_machines();
        which_remote_fu();
    }

    //----------display/print methods-------------//
    private void print_machines(){
        /***
         * Method to print the main screen of the smarthome app showing all available machines.
         * available machines are those which are not in use at the moment.
         */
        System.out.println("||||||||||||||||||||SMARTHOME APP||||||||||||||||||");
        for (Object machine : this.machine_list){
                System.out.println(machine);
        }
    }

    private void print_remote(ArrayList<Command> remote_list){
        int button_number = 1;
        System.out.println("||||||||||||||REMOTE||||||||||||||");
        for (Command command : remote_list){
            System.out.println("[" + button_number + "]" + command);
            button_number++;
        }
    }
    //-----------Helper methods---------------//
    private void which_remote_fu(){ // but which remote?
        System.out.println("Choose a machine (to choose a machine type the first capital letter e.g. O for oven): ");
        // the user defines the remote
        String remote = which_machine_fu();
        int button_number = 1;
        if (remote.equals("C")){
            print_remote(remote_cleaning_robot);
            pressButton(setCommand(remote_cleaning_robot));
        }
        else if (remote.equals("D")&& dishwasher.state){
            print_remote(remote_dishwasher);
            pressButton(setCommand(remote_dishwasher));
        }
        else if (remote.equals("D")){
            print_remote(remote_dishwasherOff);
            pressButton(setCommand(remote_dishwasherOff));
        }
        else if (remote.equals("O") && oven.power){
            print_remote(remote_oven);
            pressButton(setCommand(remote_oven));
        }
        else if (remote.equals("O")){
            print_remote(remote_ovenOff);
            pressButton(setCommand(remote_ovenOff));
        }
        else if (remote.equals("W") && washing_machine.state){
            print_remote(remote_washing_machine);
            pressButton(setCommand(remote_washing_machine));
        }
        else if (remote.equals("W")){
            print_remote(remote_washing_machineOff);
            pressButton(setCommand(remote_washing_machineOff));
        }
        else if (remote.equals("M") && microwave.state) {
            print_remote(remote_microwave);
            pressButton(setCommand(remote_microwave));
        }
        else if (remote.equals("M")) {
            print_remote(remote_microwaveOff);
            pressButton(setCommand(remote_microwaveOff));
        }
    }

    private String get_user_input(){
        /**
         * This is the method for user input
         * If a user types "e" the app will turn off.
         */
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine();
        if (letter.equals("e")){
            System.exit(0);
        }
        return letter;
    }

    private String which_machine_fu(){
        String letter = get_user_input();
        String regex = "[CDMOW]";
        Pattern pattern = Pattern.compile(regex);
        while (!letter.matches(regex)){
            System.out.println("Input not valid. Input should be the first letter of the machine in upper case.\n" +
                    "Try again: ");
            letter = get_user_input();
        }
        return letter;
    }

    private String which_command_fu(){

        String button_number = get_user_input();
        String regex = "[1-9]";
        Pattern pattern = Pattern.compile(regex);
        while (!button_number.matches(regex)){
            System.out.println("Input not valid. Must be a number from 1-9\n" +
                    "Try again: ");
            button_number = get_user_input();
        }
        return button_number;
    }

    private Command setCommand(ArrayList remote){
        System.out.println("Press a button: ");
        String command_fu = which_command_fu(); // integer 1-9
        int button_number = Integer.parseInt(command_fu);
        return (Command) remote.get(button_number - 1);
    }

    private void pressButton(Command command){
        command.execute();
    }
}

