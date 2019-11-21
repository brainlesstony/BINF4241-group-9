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
    Oven oven;
    Washing_Machine washing_machine;
    Microwave microwave;
    Cleaning_Robot cleaning_robot;
    Dishwasher dishwasher;
    //--------machine List----------//
    private ArrayList<Object> machine_list;

    //---------Command Remote List--------- // (each machine gets a list with its commands objects)
    private ArrayList<Command> remote_cleaning_robot;
    private ArrayList<Command> remote_dishwasher;
    private ArrayList<Command> remote_microwave;
    private ArrayList<Command> remote_oven;
    private ArrayList<Command> remote_washing_machine;


    public Smartphone() {

        //--------add all machine to a list---------//
        Oven oven = new Oven();
        Washing_Machine washing_machine = new Washing_Machine();
        Microwave microwave = new Microwave();
        Cleaning_Robot cleaning_robot = new Cleaning_Robot();
        Dishwasher dishwasher = new Dishwasher();

        machine_list = new ArrayList<Object>();
        machine_list.add(oven);
        machine_list.add(washing_machine);
        machine_list.add(microwave);
        machine_list.add(cleaning_robot);
        machine_list.add(dishwasher);



        //---------assign each remote variable an ArrayList-------------//
        remote_cleaning_robot = new ArrayList<Command>();
        remote_dishwasher = new ArrayList<Command>();
        remote_microwave = new ArrayList<Command>();
        remote_oven = new ArrayList<Command>();
        remote_washing_machine = new ArrayList<Command>();

        //---------init command list for Cleaning robot-----------//
        remote_cleaning_robot.add(new Cleaning_RobotCommandOff(cleaning_robot));
        remote_cleaning_robot.add(new Cleaning_RobotSetTimer(cleaning_robot));
        remote_cleaning_robot.add(new Cleaning_RobotCommandCheckBattery(cleaning_robot));
        remote_cleaning_robot.add(new Cleaning_RobotCommandCheckCharging(cleaning_robot));
        remote_cleaning_robot.add(new Cleaning_RobotCommandCheckCleaningPercentage(cleaning_robot));
        remote_cleaning_robot.add(new Cleaning_RobotCommandCompleteOutstanding(cleaning_robot));
        remote_cleaning_robot.add(new Cleaning_RobotCommandStart(cleaning_robot));

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

    public void run(){
        print_machines();
        print_remote();
    }

    //----------important methods-------------//
    public void print_machines(){
        /***
         * Method to print the main screen of the smarthome app showing all available machines.
         * available machines are those which are not in use at the moment.
         */
        System.out.println("||||||||||||||||||||SMARTHOME APP||||||||||||||||||");
        for (Object machine : this.machine_list){
                System.out.println(machine);
        }
    }

    public void print_remote(){ // but which remote?
        System.out.println("Choose a machine (to choose a machine type the first capital letter e.g. O for oven): ");
        // the user defines the remote
        String remote = which_machine_fu();
        if (remote.equals("C")){
            for (Command command : remote_cleaning_robot){
                System.out.print(command);
            }
            System.out.println(); // to make an absatz at the end
        }
        else if (remote.equals("D")){
            for (Command command : remote_dishwasher){
                System.out.print(command);
            }
            System.out.println(); // to make an absatz at the end
        }
        else if (remote.equals("O")){
            for (Command command : remote_oven){
                System.out.print(command);
            }
            System.out.println(); // to make an absatz at the end
        }
        else if (remote.equals("W")){
            for (Command command : remote_washing_machine){
                System.out.print(command);
            }
            System.out.println(); // to make an absatz at the end
        }
        else if (remote.equals("M")) {
            for (Command command : remote_microwave) {
                System.out.print(command);
            }
            System.out.println(); // to make an absatz at the end
        }
    }


    //-----------Helper methods---------------//
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

    public String which_machine_fu(){
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



/*

    public void setCommand(int i, Command c) {
        listofcommands[i] = c;
    }

    public void pressButton(int buttonNum) {
        listofcommands[buttonNum].execute();
    }

 */

}

