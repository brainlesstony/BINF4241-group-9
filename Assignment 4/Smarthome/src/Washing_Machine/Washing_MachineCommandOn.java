package Washing_Machine;

public class Washing_MachineCommandOn {
    private Washing_Machine washing_machine;
    public Washing_MachineCommandOn(Washing_Machine washing_machine){
        this.washing_machine = washing_machine;
    }

    public void execute() {
        washing_machine.on();
    }
}
