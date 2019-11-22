package Washing_Machine;

import Interfaces.Command;

public class Washing_MachineCommandSetProgram implements Command {
    Washing_Machine washing_machine;

    public Washing_MachineCommandSetProgram(Washing_Machine the_washing_machine){
        this.washing_machine = the_washing_machine;
    }

    public void execute(){
        this.washing_machine.setProgram();
    }

    @Override
    public String toString(){
        return "[SET PROGRAM]";
    }
}
