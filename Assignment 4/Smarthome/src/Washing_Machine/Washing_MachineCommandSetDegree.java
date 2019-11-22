package Washing_Machine;

import Interfaces.Command;

public class Washing_MachineCommandSetDegree implements Command{
    private Washing_Machine washing_machine;

    public Washing_MachineCommandSetDegree(Washing_Machine the_washing_machine){
        this.washing_machine = the_washing_machine;
    }

    @Override
    public void execute() {
        washing_machine.setDegree();
    }

    @Override
    public String toString(){
        return "[SET DEGREE]";
    }
}
