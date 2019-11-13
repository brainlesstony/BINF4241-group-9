package Washing_Machine;

public class Washing_MachineCommandOff {
    private Washing_Machine washing_machine;
    public Washing_MachineCommandOff(Washing_Machine washing_machine){
        this.washing_machine = washing_machine;
    }


    public void execute() {
        washing_machine.off();
    }
}
