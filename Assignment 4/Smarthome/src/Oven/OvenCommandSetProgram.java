package Oven;
import Interfaces.Command;
import java.util.Scanner;
public class OvenCommandSetProgram implements Command {
    private Oven oven;

    public OvenCommandSetProgram(Oven oven){ // Tf?
        this.oven = oven;
    }

    public void execute() {
        oven.setProgram();
    }

    @Override
    public String toString(){
        return "[SET PROGRAM]";
    }
}
