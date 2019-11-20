package Washing_Machine;

import Interfaces.Command;

public class Washing_MachineCommandOff implements Command {
    private Washing_Machine washing_machine;

    public Washing_MachineCommandOff(Washing_Machine washing_machine){
        this.washing_machine = washing_machine;
    }

    public void execute() {
        washing_machine.off();
    }
}
