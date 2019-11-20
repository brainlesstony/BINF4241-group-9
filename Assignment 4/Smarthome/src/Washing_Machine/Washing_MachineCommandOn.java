package Washing_Machine;

import Interfaces.Command;

public class Washing_MachineCommandOn implements Command {
    private Washing_Machine washing_machine;

    public Washing_MachineCommandOn(Washing_Machine washing_machine){
        this.washing_machine = washing_machine;
    }

    public void execute() {
        washing_machine.on();
    }
    
}
