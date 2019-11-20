package Washing_Machine;

import Interfaces.Command;

enum Program{Double_Rinse, Intense, Quick, Spin, None}

public class Washing_Machine {
    private Program my_program;
    private boolean state;
    public Command[] commandlist ;
    private Command Washing_MachineCommandOn;
    private Command Washing_MachineCommandOff;
    public Washing_Machine(){
        this.my_program = Program.None;
        this.Washing_MachineCommandOff = new Washing_MachineCommandOff(this);
        this.Washing_MachineCommandOn = new Washing_MachineCommandOn(this);
        this.state = false;
        this.commandlist = new Command[] {Washing_MachineCommandOn};
    }
    void on(){
        this.state = true;
        this.commandlist = getCommands();
    }
    void off(){
        this.state = false;
    }

    private Program get_program(){
        return my_program;
    }

    void set_Program(Program program_input){
        if (program_input == Program.Double_Rinse) {
            this.my_program = Program.Double_Rinse;
        }else if (program_input == Program.Intense) {
            this.my_program = Program.Intense;
        }else if (program_input == Program.Quick) {
            this.my_program = Program.Quick;
        }else if (program_input == Program.Spin){
            this.my_program = Program.Spin;
        }else{
            System.out.println("Invalid Program");;
        }
    }
    private Command[] getCommands (){
        return new Command[] {Washing_MachineCommandOn, Washing_MachineCommandOff};
    }
}
