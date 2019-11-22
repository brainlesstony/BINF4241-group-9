package Washing_Machine;

import Interfaces.Command;

public class Washing_MachineCommandStart implements Command {
    Washing_Machine washing_machine;

    public Washing_MachineCommandStart(Washing_Machine the_washing_machine){
        this.washing_machine = the_washing_machine;
    }
    public void execute(){
        this.washing_machine.startProgram();
    }

    public String toString(){
        return "[START]";
    }
}
